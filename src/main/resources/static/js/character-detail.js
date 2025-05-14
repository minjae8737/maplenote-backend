let characterDatacharacterData = null;
let isLocal = window.location.hostname === "localhost" && window.location.port === "63342";  // IDE로 파일을 열었는지 확인

const stats = [
    {id: "combat-power-value", name: "전투력"},
    {id: "attack-power-value", name: "공격력"},
    {id: "magic-power-value", name: "마력"},
    {id: "damage-value", name: "데미지", suffix: "%"},
    {id: "boss-damage-value", name: "보스 몬스터 데미지", suffix: "%"},
    {id: "final-damage-value", name: "최종 데미지", suffix: "%"},
    {id: "ignore-defense-value", name: "방어율 무시", suffix: "%"},
    {id: "critical-rate-value", name: "크리티컬 확률", suffix: "%"},
    {id: "critical-damage-value", name: "크리티컬 데미지", suffix: "%"},
    {id: "abnormal-resistance-value", name: "상태이상 내성"},
    {id: "starforce-value", name: "스타포스"},
    {id: "arcane-force-value", name: "아케인포스"},
    {id: "authentic-force-value", name: "어센틱포스"},
    {id: "str-value", name: "STR"},
    {id: "dex-value", name: "DEX"},
    {id: "int-value", name: "INT"},
    {id: "luk-value", name: "LUK"},
    {id: "hp-value", name: "HP"},
    {id: "mp-value", name: "MP"},
    {id: "item-drop-rate-value", name: "아이템 드롭률", suffix: "%"},
    {id: "meso-rate-value", name: "메소 획득량", suffix: "%"},
    {id: "buff-duration-value", name: "버프 지속시간", suffix: "%"},
    {id: "normal-monster-damage-value", name: "일반 몬스터 데미지", suffix: "%"},
    // 쿨감은 따로 처리
    {id: "attribute-resistance-ignore-value", name: "속성 내성 무시", suffix: "%"},
    {id: "additional-exp-value", name: "추가 경험치 획득", suffix: "%"},
    {id: "summon-duration-value", name: "소환수 지속시간 증가", suffix: "%"},
];

const optionMap = {
    "메소 획득량": "메획",
    "아이템 드롭률": "아획",
    "올스탯": "올스탯",
    "STR": "STR",
    "DEX": "DEX",
    "INT": "INT",
    "LUK": "LUK",
    "HP": "HP",
    "MP": "MP",
    "보스 몬스터 데미지": "보공",
    "몬스터 방어율 무시": "방무",
    "크리티컬 확률": "크확",
    "크리티컬 데미지": "크댐",
    "HP 회복 아이템 및 회복 스킬 효율": "기타",
    "MP 회복 아이템 및 회복 스킬 효율": "기타",
    "캐릭터 기준 9레벨 당 STR": "9렙 당 STR",
    "캐릭터 기준 9레벨 당 DEX": "9렙 당 DEX",
    "캐릭터 기준 9레벨 당 INT": "9렙 당 INT",
    "캐릭터 기준 9레벨 당 LUK": "9렙 당 LUK",
    "모든 스킬의 재사용 대기시간  -2초(10초 이하는 10%감소, 5초 미만으로 감소 불가)": "쿨감 -2초",
    "모든 스킬의 재사용 대기시간  -1초(10초 이하는 10%감소, 5초 미만으로 감소 불가)": "쿨감 -1초",
};

const grade = [
    {id: "레전드리", fontColor: "grade-legendary", backColor: "grade-legendary-back"},
    {id: "유니크", fontColor: "grade-unique", backColor: "grade-unique-back"},
    {id: "에픽", fontColor: "grade-epic", backColor: "grade-epic-back"},
    {id: "레어", fontColor: "grade-rare", backColor: "grade-rare-back"},
]

const petGrade = [
    {id: "루나 쁘띠", fontColor: "grade-luna-petit"},
    {id: "루나 스윗", fontColor: "grade-luna-sweat"},
    {id: "루나 드림", fontColor: "grade-luna-dream"},
];

const cashPresetMap = {
    0: "cash_item_equipment_base",
    1: "cash_item_equipment_preset_1",
    2: "cash_item_equipment_preset_2",
    3: "cash_item_equipment_preset_3",
}

const cashPrismColorMap = {}

const acrtifactOptionMap = {
    "메소 획득량 증가": "메획",
    "아이템 드롭률 증가": "아획",
    "추가 경험치 획득 증가": "추경",
    "버프 지속시간 증가": "벞지",
    "크리티컬 확률 증가": "크확",
    "크리티컬 데미지 증가": "크뎀",
    "몬스터 방어율 무시 증가": "방무",
    "보스 몬스터 공격 시 데미지 증가": "보공",
    "데미지 증가": "데미지",
    "올스탯 증가": "올스텟",
    "최대 HP/MP 증가": "HP/MP",
    "공격력/마력 증가": "공/마",
    "재사용 대기시간 미적용 확률 증가": "공/마",
    "파이널 어택류 스킬 데미지 증가": "파택",
    "소환수 지속시간 증가": "소환수",
    "상태이상 내성 증가": "내성",
};

const unionStatMap = {
    "유니온 최대 HP": "HP",
    "유니온 최대 MP": "MP",
    "유니온 INT": "INT",
    "유니온 LUK": "LUK",
    "유니온 STR": "STR",
    "유니온 DEX": "DEX",
    "유니온 공격력": "공격력",
    "유니온 마력": "마력",
}

const ctx = document.getElementById('expChart').getContext('2d');

const expChart = new Chart(ctx, {
    type: 'bar',
    data: {
        labels: [],  // x축
        datasets: [{
            label: 'exp',
            data: [],  // 데이터
            backgroundColor: 'rgba(75,192,192,0.7)',
            borderRadius: 6
        }]
    },
    options: {
        responsive: true,
        plugins: {
            tooltip: {
                callbacks: {
                    label: function (context) {
                        return context.dataset.label + ': ' + context.parsed.y + '%';
                    }
                }
            },
            legend: {
                display: false,
                labels: {
                    color: '#fff'
                }
            }
        },
        scales: {
            x: {
                grid: {
                    display: false
                },
                ticks: {
                    color: '#fff'
                }
            },
            y: {
                min: 0,
                max: 100,
                grid: {
                    display: false
                },
                ticks: {
                    color: '#fff'
                }
            }
        }
    }
});

async function loadCharacterData() {
    const nickname = decodeURIComponent(window.location.pathname.split('/').pop());

    try {
        if (isLocal) {
            // FIXME 개발용 더미데이터 나중에 삭제
            // 개발환경시 더미데이터 사용
            characterData = dummyCharacterData;
        } else {
            const response = await fetch(`/api/character/${nickname}`);
            characterData = await response.json();
        }
        init();
        updateCharacterData();

    } catch (error) {
        console.error("캐릭터 데이터를 불러오는 중 오류 발생:", error);
    }
}

function init() {
    initPresetBtns();
}

function initPresetBtns() {
    // 어빌리티
    const abilityPresetNo = characterData?.characterAbility.preset_no;
    const abilityBtn1 = document.getElementById('ability-btn1');
    const abilityBtn2 = document.getElementById('ability-btn2');
    const abilityBtn3 = document.getElementById('ability-btn3');
    abilityBtn1.addEventListener('click', () => updateAbility(1));
    abilityBtn2.addEventListener('click', () => updateAbility(2));
    abilityBtn3.addEventListener('click', () => updateAbility(3));
    // 버튼 액티브 효과 추가
    if (abilityPresetNo === 1) abilityBtn1.classList.add('active');
    if (abilityPresetNo === 2) abilityBtn2.classList.add('active');
    if (abilityPresetNo === 3) abilityBtn3.classList.add('active');

    // 하이퍼스텟
    const hyperStatPresetNo = characterData?.characterHyperStat.use_preset_no;
    const hyperStatBtn1 = document.getElementById('hyper-stat-btn1');
    const hyperStatBtn2 = document.getElementById('hyper-stat-btn2');
    const hyperStatBtn3 = document.getElementById('hyper-stat-btn3');
    hyperStatBtn1.addEventListener('click', () => updateHyperStat(1));
    hyperStatBtn2.addEventListener('click', () => updateHyperStat(2));
    hyperStatBtn3.addEventListener('click', () => updateHyperStat(3));
    // 버튼 액티브 효과 추가
    if (hyperStatPresetNo === "1") hyperStatBtn1.classList.add('active');
    if (hyperStatPresetNo === "2") hyperStatBtn2.classList.add('active');
    if (hyperStatPresetNo === "3") hyperStatBtn3.classList.add('active');

    // 장비
    const equipmentPresetNo = characterData?.characterItemEquipment.preset_no;
    const equipmentBtn1 = document.getElementById('equipment-btn1');
    const equipmentBtn2 = document.getElementById('equipment-btn2');
    const equipmentBtn3 = document.getElementById('equipment-btn3');
    equipmentBtn1.addEventListener('click', () => updateEquipment(1));
    equipmentBtn2.addEventListener('click', () => updateEquipment(2));
    equipmentBtn3.addEventListener('click', () => updateEquipment(3));
    // 버튼 액티브 효과 추가
    if (equipmentPresetNo === 1) equipmentBtn1.classList.add('active');
    if (equipmentPresetNo === 2) equipmentBtn2.classList.add('active');
    if (equipmentPresetNo === 3) equipmentBtn3.classList.add('active');

    // 캐시
    const cashPresetNo = characterData?.characterCashItemEquipment.preset_no;
    const cashBtn0 = document.getElementById('cash-btn0');
    const cashBtn1 = document.getElementById('cash-btn1');
    const cashBtn2 = document.getElementById('cash-btn2');
    const cashBtn3 = document.getElementById('cash-btn3');
    cashBtn0.addEventListener('click', () => updateCashEquip(0));
    cashBtn1.addEventListener('click', () => updateCashEquip(1));
    cashBtn2.addEventListener('click', () => updateCashEquip(2));
    cashBtn3.addEventListener('click', () => updateCashEquip(3));
    // 버튼 액티브 효과 추가
    if (equipmentPresetNo === 0) cashBtn0.classList.add('active');
    if (equipmentPresetNo === 1) cashBtn1.classList.add('active');
    if (equipmentPresetNo === 2) cashBtn2.classList.add('active');
    if (equipmentPresetNo === 3) cashBtn3.classList.add('active');

    //유니온
    const unionPresetNo = characterData?.unionRaider.use_preset_no;
    const unionBtn1 = document.getElementById('union-preset-btn1');
    const unionBtn2 = document.getElementById('union-preset-btn2');
    const unionBtn3 = document.getElementById('union-preset-btn3');
    const unionBtn4 = document.getElementById('union-preset-btn4');
    const unionBtn5 = document.getElementById('union-preset-btn5');
    unionBtn1.addEventListener('click', () => updateRaider(1));
    unionBtn2.addEventListener('click', () => updateRaider(2));
    unionBtn3.addEventListener('click', () => updateRaider(3));
    unionBtn4.addEventListener('click', () => updateRaider(4));
    unionBtn5.addEventListener('click', () => updateRaider(5));
    // 버튼 액티브 효과 추가
    if (unionPresetNo === 1) unionBtn1.classList.add('active');
    if (unionPresetNo === 2) unionBtn2.classList.add('active');
    if (unionPresetNo === 3) unionBtn3.classList.add('active');
    if (unionPresetNo === 4) unionBtn4.classList.add('active');
    if (unionPresetNo === 5) unionBtn5.classList.add('active');
}

// preset-btn 토글 이벤트
document.querySelectorAll('.preset-btn').forEach(button => {
    button.addEventListener('click', function () {
        const group = this.closest('div');
        group.querySelectorAll('.preset-btn').forEach(btn => {
            btn.classList.remove('active');
        });
        this.classList.add('active');
    });
});

function updateCharacterData() {
    // 캐릭터창 데이터
    document.getElementById('characterImage').src = characterData.characterBasic.character_image;
    document.getElementById('characterName').textContent = characterData.characterBasic.character_name;
    document.getElementById('worldName').textContent = characterData.characterBasic.world_name;
    document.getElementById('characterLevel').textContent = `Lv. ${characterData.characterBasic.character_level}`;
    document.getElementById('characterClass').textContent = characterData.characterBasic.character_class;
    document.getElementById('createDate').textContent = convertDate(characterData.characterBasic.character_date_create);
    document.getElementById('popularity').textContent = `인기도 ${characterData.characterPopularity.popularity}`;

    // 캐릭터 스텟
    updateStat();

    // 어빌리티
    updateAbility(characterData.characterAbility.preset_no);

    // 하이퍼 스텟
    updateHyperStat(characterData.characterHyperStat.use_preset_no);

    // 장비 목록
    updateEquipment(characterData.characterItemEquipment.preset_no);

    // 캐시 장비 목록
    updateCashEquip(characterData.characterCashItemEquipment.preset_no)

    // 펫 목록
    updatePet();

    //exp 히스토리
    updateExpChart();

    // 스킬 목록
    updateSkillList();

    // 아티팩트 목록
    updateUnionArtifact();

    // 유니온 레이더
    updateRaider(characterData.unionRaider.use_preset_no);
}

// 스탯 가져오는 함수
function getCharacterStatValue(statName) {
    if (!characterData || !characterData.characterStat) {
        return "none";
    }

    const stat = characterData.characterStat.final_stat.find(
        (stat) => stat.stat_name === statName
    );

    return stat ? stat.stat_value : "none";
}

// 스탯 이름을 받아 해당 스탯 값을 가져오는 함수
function updateStat() {
    // 일반 스탯 처리
    stats.forEach(stat => {
        const element = document.getElementById(stat.id);
        if (element) {
            let value = getCharacterStatValue(stat.name);
            if (stat.suffix) {
                value += stat.suffix;
            }
            element.textContent = value;
        }
    });

    // 재사용 대기시간 감소 처리
    const cooldownElement = document.getElementById("cooldown-reduction-value");
    if (cooldownElement) {
        const percent = getCharacterStatValue("재사용 대기시간 감소 (%)");
        const seconds = getCharacterStatValue("재사용 대기시간 감소 (초)");
        cooldownElement.textContent = `${percent}% / ${seconds}초`;
    }

    convertStat();
}

function convertDate(date) {
    return date.substring(0, 10);
}

// 스텟 단위 변환
function convertStat() {
    document.getElementById('combat-power-value').textContent = convertCombatPower(document.getElementById('combat-power-value').textContent);
    document.getElementById('attack-power-value').textContent = Number(document.getElementById('attack-power-value').textContent).toLocaleString();
    document.getElementById('magic-power-value').textContent = Number(document.getElementById('magic-power-value').textContent).toLocaleString();
    document.getElementById('arcane-force-value').textContent = Number(document.getElementById('arcane-force-value').textContent).toLocaleString();
    document.getElementById('authentic-force-value').textContent = Number(document.getElementById('authentic-force-value').textContent).toLocaleString();
    document.getElementById('str-value').textContent = Number(document.getElementById('str-value').textContent).toLocaleString();
    document.getElementById('dex-value').textContent = Number(document.getElementById('dex-value').textContent).toLocaleString();
    document.getElementById('int-value').textContent = Number(document.getElementById('int-value').textContent).toLocaleString();
    document.getElementById('luk-value').textContent = Number(document.getElementById('luk-value').textContent).toLocaleString();
    document.getElementById('hp-value').textContent = Number(document.getElementById('hp-value').textContent).toLocaleString();
    document.getElementById('mp-value').textContent = Number(document.getElementById('mp-value').textContent).toLocaleString();
}

// 전투력 표기 변환
function convertCombatPower(combatPowerValue) {
    let combatPowerNum = Number(combatPowerValue);
    const units = ["", "만", "억"]
    let result = "";
    let unitsIdx = 0;

    while (combatPowerNum > 0) {
        let remain = combatPowerNum % 10000;
        if (remain > 0) {
            result = remain + units[unitsIdx] + " " + result;
        }
        combatPowerNum = Math.floor(combatPowerNum / 10000);
        unitsIdx++;
    }

    return result;
}

// 어빌리티 업데이트
function updateAbility(presetNum) {
    const abilityParent = document.getElementById('ability-parent');
    let abilityData = characterData.characterAbility[`ability_preset_${presetNum}`];

    // 하위 요소 모두 삭제
    abilityParent.innerHTML = '';

    let html = '';

    for (const ability of abilityData.ability_info) {
        html += `
            <div class="col-12">
                <span class="stat-value">${ability.ability_value}</span>
            </div>
        `;
    }

    abilityParent.innerHTML = html;
}

// 하이퍼스텟 업데이트
function updateHyperStat(presetNum) {
    const hyperStatParent = document.getElementById('hyper-stat-parent');
    let hyperStatData = characterData.characterHyperStat[`hyper_stat_preset_${presetNum}`];

    // 하위 요소 모두 삭제
    hyperStatParent.innerHTML = '';

    let html = '';

    for (const hyperStat of hyperStatData) {

        if (hyperStat.stat_increase != null) {
            html += `
                <div class="col-12">
                    <span class="badge text-bg-secondary">Lv.${hyperStat.stat_level}</span>
                    <span class="stat-value">${hyperStat.stat_increase}</span>
                </div>
            `;
        }
    }

    hyperStatParent.innerHTML = html;
}

// 장비목록 업데이트
function updateEquipment(presetNum) {
    const equipParent = document.getElementById('equip-parent');
    let equipmentData = characterData.characterItemEquipment[`item_equipment_preset_${presetNum}`];

    // 하위 요소 모두 삭제
    equipParent.innerHTML = '';

    let html = '';

    for (const equipment of equipmentData) {

        // 스타포스
        const starforceText = equipment.starforce > 0 ? `★${equipment.starforce}` : "";
        const starforceTextClass = equipment.starforce > 0 ? `starforce-label` : "";

        // 잠재능력
        const potentialGrade = grade.find(grade => grade.id === equipment.potential_option_grade);
        const potentialGradeClass = potentialGrade?.id !== undefined ? `equip-label ${potentialGrade.fontColor}` : '';

        // 에디셔널
        const additionalGrade = grade.find(grade => grade.id === equipment.additional_potential_option_grade);
        const additionalGradeClass = additionalGrade?.id !== undefined ? `equip-label ${additionalGrade.fontColor}` : '';

        const potentialOptionText =
            `${getEquipOptionNameShorten(equipment.potential_option_1)} ` +
            `${getEquipOptionNameShorten(equipment.potential_option_2)} ` +
            `${getEquipOptionNameShorten(equipment?.potential_option_3 || '')}`;
        const additionalOptionText =
            `${getEquipOptionNameShorten(equipment.additional_potential_option_1)} ` +
            `${getEquipOptionNameShorten(equipment.additional_potential_option_2)} ` +
            `${getEquipOptionNameShorten(equipment.additional_potential_option_3) || ''}`;

        html += `
                <div class="col">
                    <div class="equip-card">
                        <div class="equip-content">
                            <div class="equip-img-wrapper">
                                <img src="${equipment.item_icon}" class="equip-img" alt="">
                            </div>
                            <div class="equip-info">
                                <span class="${starforceTextClass}">${starforceText}</span>
                                <span>${equipment.item_name}</span>
                                <span class="${potentialGradeClass}">${potentialOptionText}</span>
                                <span class="${additionalGradeClass}">${additionalOptionText}</span>
                            </div>
                        </div>
                    </div>
                </div>
            `;
    }

    equipParent.innerHTML = html;
}

// 캐시 장비목록 업데이트
function updateCashEquip(presetNum) {
    const cashParent = document.getElementById('cash-parent');
    let cashPresetName = cashPresetMap[presetNum];
    let cashEquipmentData = characterData.characterCashItemEquipment[cashPresetName];

    // 하위 요소 모두 삭제
    cashParent.innerHTML = '';

    let html = '';

    for (const cashEquipment of cashEquipmentData) {

        const prismText = cashEquipment.cash_item_coloring_prism !== null ?
            `${getCashPrismColorRangeShorten(cashEquipment.cash_item_coloring_prism.color_range)} ` +
            `/색조 ${getSignedNumber(cashEquipment.cash_item_coloring_prism.hue)}` +
            `/채도 ${getSignedNumber(cashEquipment.cash_item_coloring_prism.saturation)}` +
            `/명도 ${getSignedNumber(cashEquipment.cash_item_coloring_prism.value)}` : "";

        html += `
            <div class="col">
                <div class="equip-card">
                    <div class="equip-content">
                        <div class="equip-img-wrapper">
                            <img src="${cashEquipment.cash_item_icon}" class="equip-img" alt="">
                        </div>
                        <div class="equip-info">
                            <span class="cash-card-partname">${cashEquipment.cash_item_equipment_part}</span>
                            <span class="cash-card-itemname">${cashEquipment.cash_item_name}</span>
                            <span class="cash-card-prism">${prismText}</span>
                        </div>
                    </div>
                </div>
            </div>
        `;
    }

    cashParent.innerHTML = html;

}

// 펫 목록 업데이트
const updatePet = () => {
    const petParent = document.getElementById('pet-parent');
    const petEquipParent = document.getElementById('pet-equipment-parent');

    const petDatas = characterData.characterPetEquipment;
    const pets = [1, 2, 3];

    let petHtml = '';
    let petEquipHtml = '';

    pets.forEach(i => {

        // 펫
        const petName = petDatas[`pet_${i}_name`];
        const petGradeName = petDatas[`pet_${i}_pet_type`] !== null ? petDatas[`pet_${i}_pet_type`] : '';
        const findPetGrade = petGrade.find(grade => grade.id === petGradeName);
        const petGradeClass = findPetGrade !== null ? `pet-grade ${findPetGrade?.fontColor}` : '';

        // 펫장비
        const petEquipIcon = petDatas[`pet_${i}_equipment`]?.item_icon || '';
        const petEquipName = petDatas[`pet_${i}_equipment`]?.item_name || '';
        const petOptions = petDatas[`pet_${i}_equipment`]?.item_option || [];
        let petOptionText = '';

        for (const petOption of petOptions) {
            let optionText = `${petOption.option_type} ${getSignedNumber(petOption.option_value)} `;
            petOptionText += optionText;
        }

        petOptionText.trim();

        petHtml += `
            <div>
                <div class="pet-content">
                    <div class="pet-img-wrapper">
                        <img src="${petDatas[`pet_${i}_icon`]}">
                    </div>
                    <div class="pet-info">
                        <span class="${petGradeClass}">${petGradeName}</span>
                        <span class="pet-name">${petName}</span>
                    </div>
                </div>
            </div>
        `;

        petEquipHtml += `
            <div>
                <div class="pet-content">
                    <div class="pet-img-wrapper">
                        <img src="${petEquipIcon}">
                    </div>
                    <div class="pet-info">
                        <span class="pet-name">${petEquipName}</span>
                        <span class="pet-equip-effect">${petOptionText}</span>
                    </div>
                </div>
            </div>
        `;

    });

    petParent.innerHTML = petHtml;
    petEquipParent.innerHTML = petEquipHtml;

};

// 장비 옵션명을 짧게 변환하는 함수
const getEquipOptionNameShorten = (optionName) => {
    if (!optionName) return "";

    const [optionText, valueText] = optionName.split("+");
    const trimmedOption = optionText.replace(":", "").trim();
    const value = valueText ? `+${valueText.trim()}` : "";
    const shortName = optionMap[trimmedOption] || trimmedOption;

    return `${shortName} ${value}`.trim();
};

// 프리즘 '계열' 단어를 빼는 함수
const getCashPrismColorRangeShorten = (colorRange) => {
    if (!colorRange) return "";

    return trimmedColorRagne = colorRange.replace("계열", "").trim();
}

// 숫자 양수면 '+'를 붙이고 음수면 그대로 반환해주는 함수
const getSignedNumber = (value) => {
    return Number.parseInt(value) > 0 ? `+${value}` : value;
}

// 경험치 목록 표시
function updateExpChart() {
    const expDatas = characterData.characterExps.toReversed();
    let explabel = [];
    let exps = [];

    for (const expData of expDatas) {
        explabel.push(formattingDate(expData.date));
        exps.push(expData.character_exp_rate);
    }

    expChart.data.labels = explabel;
    expChart.data.datasets[0].data = exps;
    expChart.update();
}

function formattingDate(date) {
    return date.substring(8, 10) + "일";
}

// 스킬 목록 업데이트
function updateSkillList() {
    const _5thSkillParent = document.getElementById('5th-skill-parent');
    const _6thSkillParent = document.getElementById('6th-skill-parent');

    const characterSkillList = characterData?.characterSkills.character_skill_list || [];
    const _5thSkillList = characterSkillList.find((s) => s.character_skill_grade === '5')?.character_skill || [];
    const _6thSkillList = characterSkillList.find((s) => s.character_skill_grade === '6')?.character_skill || [];

    let _5thSkillHtml = '';
    let _6thSkillHtml = '';

    for (const skill of _5thSkillList) {
        const skillIcon = skill.skill_icon;
        const skillName = skill.skill_name;
        const skillLevel = skill.skill_level;

        _5thSkillHtml += `
            <div class="skill-card">
                <div class="skill-icon-wrapper">
                    <img src="${skillIcon}">
                </div>
                <span class="skill-name">${skillName}</span>
                <span>${skillLevel}</span>
            </div>
        `;

    }

    for (const skill of _6thSkillList) {
        const skillName = skill.skill_name;
        const skillLevel = skill.skill_level;
        const skillIcon = skill.skill_icon;

        _6thSkillHtml += `
            <div class="skill-card">
                <div class="skill-icon-wrapper">
                    <img src="${skillIcon}">
                </div>
                <span class="skill-name">${skillName}</span>
                <span>${skillLevel}</span>
            </div>
        `;
    }

    _5thSkillParent.innerHTML = _5thSkillHtml;
    _6thSkillParent.innerHTML = _6thSkillHtml;
}

function updateUnionArtifact() {
    const artifactCardParent = document.getElementById('artifact-card-parent');
    const artifactEffectParent = document.getElementById('artifact-effect-parent');

    const artifactData = characterData?.unionArtifact || '';
    const artifactLevel = characterData?.union.union_artifact_level || '';

    let cardHtml = '';
    let effectHtml = '';

    const artifactCrystals = artifactData?.union_artifact_crystal || [];
    const artifactEffect = artifactData?.union_artifact_effect || [];

    // 아티팩트 카드
    for (const crystal of artifactCrystals) {

        const artifactLevelIcon = getDiamondIcon(crystal.level);
        const optionName1 = acrtifactOptionMap[crystal.crystal_option_name_1];
        const optionName2 = acrtifactOptionMap[crystal.crystal_option_name_2];
        const optionName3 = acrtifactOptionMap[crystal.crystal_option_name_3];

        cardHtml += `
            <div class="artifact-card">
                <div>
                    ${artifactLevelIcon}
                </div>
                <div>
                    <span class="artifact-label">${optionName1}</span>
                    <span class="artifact-label">${optionName2}</span>
                    <span class="artifact-label">${optionName3}</span>
                </div>
            </div>        
        `;
    }

    // 아티팩트 효과
    for (const effect of artifactEffect) {
        const level = effect.level;
        const name = effect.name;

        effectHtml += `
            <div>
                <span class="badge text-bg-secondary">Lv.${level}</span> <span class="artifact-label">${name}</span>
            </div>            
        `;

    }

    artifactCardParent.innerHTML = cardHtml;
    artifactEffectParent.innerHTML = effectHtml;

}

function getDiamondIcon(quantity) {

    let html = '';
    let color = quantity === 5 ? '#6D62A1' : '#198ca8';

    for (let i = 0; i < quantity; i++) {
        html += `
            <svg xmlns="http://www.w3.org/2000/svg" width="12" height="12" fill="currentColor"
                 class="bi bi-suit-diamond-fill" viewBox="0 0 16 16">
                <path d="M2.45 7.4 7.2 1.067a1 1 0 0 1 1.6 0L13.55 7.4a1 1 0 0 1 0 1.2L8.8 14.933a1 1 0 0 1-1.6 0L2.45 8.6a1 1 0 0 1 0-1.2"
                      fill="${color}"/>
            </svg>
        `;
    }

    return html;
}

function updateRaider(presetNum) {

    const cellParent = document.getElementById('raider-cell-parent');
    const effectParent = document.getElementById('raider-effect-parent');
    const occupiedParent = document.getElementById('raider-occupied-parent');
    let raiderData = characterData?.unionRaider[`union_raider_preset_${presetNum}`] || '';

    const raiderStat = raiderData.union_raider_stat.sort();  //공격대원 효과
    const occupiedStat = raiderData.union_occupied_stat.sort(); //점령 효과
    const innerStat = raiderData.union_inner_stat; //공격대 배치(11시부터 시계방향으로 스텟 배치)

    const blockDatas = raiderData.union_block; //유니온블록 정보
    const CELLSIZE = 14;

    let cellHtml = '';
    let effectHtml = '';
    let occupiedHtml = '';

    // 스텟 배치
    for (const stat of innerStat) {
        let statId = stat.stat_field_id;
        const statLabel = document.getElementById(`raider-stat-name${statId}`);

        statLabel.textContent = unionStatMap[stat.stat_field_effect];
    }

    // 전투지도 칸 채우기
    for (const blockData of blockDatas) {
        const positions = blockData.block_position;

        for (const position of positions) {
            const pos = calCellPos({x: position.x, y: position.y}, CELLSIZE);

            cellHtml += `
                <div class="raider-cell" style="left: ${pos.x}px; top: ${pos.y}px;"></div>
            `;
        }
    }

    // 공격대원 효과
    for (const stat of raiderStat) {
        effectHtml += `
            <span class="raider-stat">${stat}</span>
        `;
    }

    // 점령 효과
    for (const stat of occupiedStat) {
        occupiedHtml += `
            <span class="raider-stat">${stat}</span>
        `;
    }

    cellParent.innerHTML = cellHtml;
    effectParent.innerHTML = effectHtml;
    occupiedParent.innerHTML = occupiedHtml;

}

function calCellPos(pos, CELLSIZE) {
    return {x: (pos.x + 11) * CELLSIZE, y: (10 - pos.y) * CELLSIZE}
}

window.onload = loadCharacterData;