let characterData = null;

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
    "보스 몬스터 공격 시 데미지": "보공",
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

// const gradeClassMap = {
//     '레전드리': ['grade-legendary', 'grade-legendary-back'],
//     '유니크': ['grade-unique', 'grade-unique-back'],
//     '에픽': ['grade-epic', 'grade-epic-back'],
//     '레어': ['grade-rare', 'grade-rare-back'],
// };

const grade = [
    {id: "레전드리", fontColor: "grade-legendary", backColor: "grade-legendary-back"},
    {id: "유니크", fontColor: "grade-unique", backColor: "grade-unique-back"},
    {id: "에픽", fontColor: "grade-epic", backColor: "grade-epic-back"},
    {id: "레어", fontColor: "grade-rare", backColor: "grade-rare-back"},
]

async function loadCharacterData() {
    const nickname = decodeURIComponent(window.location.pathname.split('/').pop());

    try {
        const response = await fetch(`/api/character/${nickname}`);
        characterData = await response.json();
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
    document.getElementById('ability-btn1').addEventListener('click', () => updateAbility(1));
    document.getElementById('ability-btn2').addEventListener('click', () => updateAbility(2));
    document.getElementById('ability-btn3').addEventListener('click', () => updateAbility(3));

    // 하이퍼스텟
    document.getElementById('hyper-stat-btn1').addEventListener('click', () => updateHyperStat(1));
    document.getElementById('hyper-stat-btn2').addEventListener('click', () => updateHyperStat(2));
    document.getElementById('hyper-stat-btn3').addEventListener('click', () => updateHyperStat(3));

    // 장비
    document.getElementById('equipment-btn1').addEventListener('click', () => updateEquipment(1));
    document.getElementById('equipment-btn2').addEventListener('click', () => updateEquipment(2));
    document.getElementById('equipment-btn3').addEventListener('click', () => updateEquipment(3));
}


function updateCharacterData() {
    // 캐릭터창 데이터
    document.getElementById('characterImage').src = characterData.characterBasic.character_image;
    document.getElementById('characterName').textContent = characterData.characterBasic.character_name;
    document.getElementById('worldName').textContent = characterData.characterBasic.world_name;
    document.getElementById('characterLevel').textContent = `Lv. ${characterData.characterBasic.character_level}`;
    document.getElementById('characterClass').textContent = characterData.characterBasic.character_class;
    document.getElementById('createDate').textContent = convertDate(characterData.characterBasic.character_date_create);
    document.getElementById('popularity').textContent = characterData.characterPopularity.popularity;

    // 캐릭터 스텟
    updateStat();

    // 어빌리티
    updateAbility(characterData.characterAbility.preset_no);

    // 하이퍼 스텟
    updateHyperStat(characterData.characterHyperStat.use_preset_no);

    // 장비 목록
    updateEquipment(characterData.characterItemEquipment.preset_no)
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
            `;
    }

    equipParent.innerHTML = html;
}

// 옵션명을 짧게 변환하는 함수
const getEquipOptionNameShorten = (optionName) => {
    if (!optionName) return "";

    const [optionText, valueText] = optionName.split("+");
    const trimmedOption = optionText.replace(":", "").trim();
    const value = valueText ? `+${valueText.trim()}` : "";

    const shortName = optionMap[trimmedOption] || trimmedOption;

    return `${shortName} ${value}`.trim();
};


window.onload = loadCharacterData;