let calendarEl;
let calendar;

const MAX_MESO = 1999999999999; //1조 9999억 9999만 9999 메소

const bossList = [
    {
        name: "자쿰",
        name_eng: "zakum",
        image: "../../static/images/boss/boss_zakum.png",
        rewards: {
            easy: {meso: 114000, weekly: false},
            normal: {meso: 349000, weekly: false},
            chaos: {meso: 8080000, weekly: true}
        }
    },
    {
        name: "혼테일",
        name_eng: "horntail",
        image: "../../static/images/boss/boss_horntail.png",
        rewards: {
            easy: {meso: 502000, weekly: false},
            normal: {meso: 576000, weekly: false},
            chaos: {meso: 770000, weekly: false}
        }
    },
    {
        name: "핑크빈",
        name_eng: "pink_bean",
        image: "../../static/images/boss/boss_pink_bean.png",
        rewards: {
            normal: {meso: 799000, weekly: false},
            chaos: {meso: 6580000, weekly: true}
        }
    },
    {
        name: "파풀라투스",
        name_eng: "papulatus",
        image: "../../static/images/boss/boss_papulatus.png",
        rewards: {
            easy: {meso: 390000, weekly: false},
            normal: {meso: 1520000, weekly: false},
            chaos: {meso: 17300000, weekly: true}
        }
    },
    {
        name: "시그너스",
        name_eng: "cygnus",
        image: "../../static/images/boss/boss_cygnus.png",
        rewards: {
            easy: {meso: 4550000, weekly: true},
            normal: {meso: 7500000, weekly: true},
        }
    },
    {
        name: "힐라",
        name_eng: "hilla",
        image: "../../static/images/boss/boss_hilla.png",
        rewards: {
            normal: {meso: 455000, weekly: false},
            hard: {meso: 5750000, weekly: true}
        }
    },
    {
        name: "반 레온",
        name_eng: "von_leon",
        image: "../../static/images/boss/boss_von_leon.png",
        rewards: {
            easy: {meso: 602000, weekly: false},
            normal: {meso: 830000, weekly: false},
            hard: {meso: 1390000, weekly: false}
        }
    },
    {
        name: "아카이럼",
        name_eng: "arkarium",
        image: "../../static/images/boss/boss_arkarium.png",
        rewards: {
            easy: {meso: 656000, weekly: false},
            normal: {meso: 1430000, weekly: false}
        }
    },
    {
        name: "매그너스",
        name_eng: "magnus",
        image: "../../static/images/boss/boss_magnus.png",
        rewards: {
            easy: {meso: 411000, weekly: false},
            normal: {meso: 1480000, weekly: false},
            hard: {meso: 8560000, weekly: true}
        }
    },
    {
        name: "블러디퀸",
        name_eng: "crimson_queen",
        image: "../../static/images/boss/boss_crimson_queen.png",
        rewards: {
            normal: {meso: 551000, weekly: false},
            chaos: {meso: 8140000, weekly: true}
        }
    },
    {
        name: "반반",
        name_eng: "von_bon",
        image: "../../static/images/boss/boss_von_bon.png",
        rewards: {
            normal: {meso: 551000, weekly: false},
            chaos: {meso: 8150000, weekly: true}
        }
    },
    {
        name: "피에르",
        name_eng: "pierre",
        image: "../../static/images/boss/boss_pierre.png",
        rewards: {
            normal: {meso: 551000, weekly: false},
            chaos: {meso: 8170000, weekly: true}
        }
    },
    {
        name: "벨룸",
        name_eng: "vellum",
        image: "../../static/images/boss/boss_vellum.png",
        rewards: {
            normal: {meso: 551000, weekly: false},
            chaos: {meso: 9280000, weekly: true}
        }
    },
    {
        name: "카웅",
        name_eng: "OMNI-CLN",
        image: "../../static/images/boss/boss_OMNI-CLN.png",
        rewards: {
            normal: {meso: 712000, weekly: false}
        }
    },
    {
        name: "스우",
        name_eng: "lotus",
        image: "../../static/images/boss/boss_lotus.png",
        rewards: {
            normal: {meso: 22000000, weekly: true},
            hard: {meso: 77400000, weekly: true},
            extreme: {meso: 549000000, weekly: true}
        }
    },
    {
        name: "데미안",
        name_eng: "damien",
        image: "../../static/images/boss/boss_damien.png",
        rewards: {
            normal: {meso: 23000000, weekly: true},
            hard: {meso: 73500000, weekly: true}
        }
    },
    {
        name: "가디언 엔젤 슬라임",
        name_eng: "guardian_angel_slime",
        image: "../../static/images/boss/boss_guardian_angel_slime.png",
        rewards: {
            normal: {meso: 33500000, weekly: true},
            chaos: {meso: 113000000, weekly: true}
        }
    },
    {
        name: "루시드",
        name_eng: "lucid",
        image: "../../static/images/boss/boss_lucid.png",
        rewards: {
            easy: {meso: 39200000, weekly: true},
            normal: {meso: 46900000, weekly: true},
            hard: {meso: 94500000, weekly: true},
        }
    },
    {
        name: "윌",
        name_eng: "will",
        image: "../../static/images/boss/boss_will.png",
        rewards: {
            easy: {meso: 42500000, weekly: true},
            normal: {meso: 54100000, weekly: true},
            hard: {meso: 116000000, weekly: true}
        }
    },
    {
        name: "더스크",
        name_eng: "gloom",
        image: "../../static/images/boss/boss_gloom.png",
        rewards: {
            normal: {meso: 57900000, weekly: true},
            chaos: {meso: 105000000, weekly: true}
        }
    },
    {
        name: "듄켈",
        name_eng: "darknell",
        image: "../../static/images/boss/boss_darknell.png",
        rewards: {
            normal: {meso: 62500000, weekly: true},
            hard: {meso: 142000000, weekly: true}
        }
    },
    {
        name: "진 힐라",
        name_eng: "verus_hilla",
        image: "../../static/images/boss/boss_verus_hilla.png",
        rewards: {
            normal: {meso: 107000000, weekly: true},
            hard: {meso: 160000000, weekly: true}
        }
    },
    {
        name: "선택받은 세렌",
        name_eng: "seren",
        image: "../../static/images/boss/boss_seren.png",
        rewards: {
            normal: {meso: 295000000, weekly: true},
            hard: {meso: 440000000, weekly: true},
            extreme: {meso: 2420000000, weekly: true}
        }
    },
    {
        name: "감시자 칼로스",
        name_eng: "kalos",
        image: "../../static/images/boss/boss_kalos.png",
        rewards: {
            easy: {meso: 345000000, weekly: true},
            normal: {meso: 510000000, weekly: true},
            chaos: {meso: 1120000000, weekly: true},
            extreme: {meso: 2700000000, weekly: true}
        }
    },
    {
        name: "카링",
        name_eng: "kaling",
        image: "../../static/images/boss/boss_kaling.png",
        rewards: {
            easy: {meso: 381000000, weekly: true},
            normal: {meso: 595000000, weekly: true},
            hard: {meso: 1310000000, weekly: true},
            extreme: {meso: 3150000000, weekly: true}
        }
    },
    {
        name: "림보",
        name_eng: "limbo",
        image: "../../static/images/boss/boss_limbo.png",
        rewards: {
            normal: {meso: 900000000, weekly: true},
            hard: {meso: 1930000000, weekly: true}
        }
    },
    {
        name: "발드릭스",
        name_eng: "baldrix",
        image: "../../static/images/boss/boss_baldrix.png",
        rewards: {
            normal: {meso: 1200000000, weekly: true},
            hard: {meso: 2160000000, weekly: true}
        }
    },
    {
        name: "검은 마법사",
        name_eng: "black_mage",
        image: "../../static/images/boss/boss_black_mage.png",
        rewards: {
            hard: {meso: 1000000000, monthly: true},
            extreme: {meso: 9200000000, monthly: true}
        }
    }
];

const bossBtnClassMap = {
    "easy" : "boss-level-easy-btn",
    "normal" : "boss-level-normal-btn",
    "hard" : "boss-level-hard-btn",
    "chaos" : "boss-level-chaos-btn",
    "extreme" : "boss-level-extreme-btn",
}


document.addEventListener('DOMContentLoaded', function () {
    calendarEl = document.getElementById('calendar');
    calendar = new FullCalendar.Calendar(calendarEl, {
        timeZone: 'local',
        locale: 'ko',
        height: '100%',
        initialView: 'dayGridMonth',
        dayMaxEvents: 3,
        eventContent: function (arg) {
            const type = arg.event.extendedProps.type;

            if (type === 'boss-drop') {
                return {
                    html: `
                        <div class="">
                          <img src="${arg.event.extendedProps.icon}" class="event-icon" />
                          <span>${arg.event.title}</span>
                        </div>
                    `
                };
            } else if (type === 'text') {
                return {
                    html: `
                        <span class="text-event">${arg.event.title}</span>
                    `
                };
            } else {
                // 기본 렌더링
                return true;
            }
        },

    });
    calendar.render();
});

async function loadDiaryData() {

    try {
        // const response = await fetch(`/api/character/${nickname}`);
        // characterData = await response.json();

        init();

    } catch (error) {
        console.error("데이터를 불러오는 중 오류 발생:", error);
    }
}

function init() {
    initListener();
    initBossAddForm();
}

function initListener() {

    // 재획
    const addGrindBtn = document.getElementById('add-grind-btn');
    addGrindBtn.addEventListener('click', () => {
        document.getElementById('add-grind-btn-parent').classList.add('hidden');
        document.getElementById('grind-form').classList.remove('hidden');
    });

    const grindMesoInputFeild = document.getElementById('meso');
    const grindMesoAddText = document.getElementById('grind-meso-add-text');
    grindMesoInputFeild.addEventListener('keyup', function (event) {
        if (/^[0-9]$/.test(event.key) || event.key === 'Backspace' || event.key === 'Delete') {

            if (Number(grindMesoInputFeild.value) > MAX_MESO) {
                grindMesoInputFeild.value = MAX_MESO;
            }
            grindMesoAddText.innerText = `${convertMesoText(grindMesoInputFeild.value)} 메소`;
        }
    })

    const grindBtnCancel = document.getElementById('grind-btn-cancel');
    grindBtnCancel.addEventListener('click', () => onClickGrindBtnCancel());

    const grindBtnSave = document.getElementById('grind-btn-save');
    grindBtnSave.addEventListener('click', () => onClickGrindAdd());

    //보스
    const addBossBtn = document.getElementById('add-boss-btn');
    addBossBtn.addEventListener('click', () => {
        document.getElementById('add-boss-btn-parent').classList.add('hidden');
        document.getElementById('boss-form').classList.remove('hidden');
    });

    const bossBtnCancel = document.getElementById('boss-btn-cancel');
    bossBtnCancel.addEventListener('click', () => onClickBossBtnCancel());

    const bossBtnSave = document.getElementById('boss-btn-save');
    bossBtnSave.addEventListener('click', () => onClickBossAdd());


}

function onClickGrindBtnCancel() {
    document.getElementById('add-grind-btn-parent').classList.remove('hidden');
    document.getElementById('grind-form').classList.add('hidden');
}

function onClickBossBtnCancel() {
    document.getElementById('add-boss-btn-parent').classList.remove('hidden');
    document.getElementById('boss-form').classList.add('hidden');
}

function onClickGrindAdd() {
    const grindingTime = document.getElementById('grinding-time');
    const solerdaFrag = document.getElementById('solerda-frag');
    const meso = document.getElementById('meso');

    const values = [
        {el: grindingTime, label: "재획 시간"},
        {el: solerdaFrag, label: "솔 에르다 조각"},
        {el: meso, label: "메소"}
    ];

    const isVaild = checkVaildGrindData(values);
    if (!isVaild) return;

    // 서버에 save 요청


    // 성공시 저장후 라인 추가
    const grindLogParent = document.getElementById('grind-log-parent');
    const grindResultParent = document.getElementById('grind-result-parent');
    let grindLogHtml = grindLogParent.innerHTML;
    let grindResultHtml = '';

    const grindingTimeData = grindingTime.value.trim();
    const solerdaFragData = solerdaFrag.value.trim();
    const mesoData = meso.value.trim();

    grindLogHtml += `
        <div class="row">
            <div class="col d-flex align-items-center gap-2">
                <img class="diary-img-wrapper"
                     src="../../static/images/item/small_wealth_aquisition_potion.png">
                <span class="text-center">${grindingTimeData} 소재비</span>
            </div>
            <div class="col d-flex align-items-center gap-2">
                <img class="diary-img-wrapper" src="../../static/images/item/frags.webp">
                <span class="text-center">${solerdaFragData}개</span>
            </div>
            <div class="col d-flex align-items-center gap-2">
                <img class="diary-img-wrapper" src="../../static/images/item/meso.png">
                <span class="text-center">${convertMesoText(mesoData)} 메소</span>
            </div>
        </div>
    `;

    grindLogParent.innerHTML = grindLogHtml;

    //FIXME 하루 누적도 바꿔야함

    // 실패시 서버오류 알터창띄우고 입력값유지
}

function checkVaildGrindData(values) {
    for (const {el, label} of values) {
        const value = el.value.trim();

        if (value === "" || isNaN(value)) {
            alert(`${label}에 숫자를 입력해주세요.`);
            el.focus();
            return false;
        }

        if (parseInt(value) < 0) {
            alert(`${label}에는 0 이상의 값을 입력해주세요.`);
            el.focus();
            return false;
        }
    }

    return true;
}

function convertMesoText(meso) {
    let mesoNum = Number(meso);

    if (Number(mesoNum) > MAX_MESO) {
        mesoNum = MAX_MESO;
    }

    const units = ["", "만", "억", "조"]
    let result = "";
    let unitsIdx = 0;

    while (mesoNum > 0) {
        let remain = mesoNum % 10000;
        if (remain > 0) {
            result = remain + units[unitsIdx] + " " + result;
        }
        mesoNum = Math.floor(mesoNum / 10000);
        unitsIdx++;
    }

    return result;
}

function initBossAddForm() {
    const bossInputParent = document.getElementById('boss-list-input-parent');

    let bossFormHtml = '';

    for (const boss of bossList) {

        let bossLevelHtml = '';

        for (const [level, data] of Object.entries(boss.rewards)) {

            const btnClass = bossBtnClassMap[level];

            bossLevelHtml += `
                <input type="checkbox" class="btn-check boss-checkbox" id="${boss.name_eng}-${level}" autocomplete="off">
                <label class="${btnClass}" for="${boss.name_eng}-${level}">${level.toUpperCase()}</label>
            `;
        }

        bossFormHtml += `
            <div class="row align-items-center mb-3 boss-input">
                <!-- 보스 이미지/이름 -->
                <div class="col-md-3 d-flex align-items-center gap-2">
                    <img src="${boss.image}" alt="보스" style="width: 84px; height: auto;">
                    <span class="fw-bold">${boss.name}</span>
                </div>

                <!-- 난이도 버튼 -->
                <div class="col-md-9 d-flex gap-2 flex-wrap">
                    ${bossLevelHtml}
                </div>
            </div>
        `;

    }

    bossInputParent.innerHTML = bossFormHtml;
}

function onClickBossAdd() {
    const bossCheckBoxList = document.getElementsByClassName('boss-checkbox');

    let checkedBossList = [];

    // 체크된 보스 정보 저장
    for (const bossCheckBoxElement of bossCheckBoxList) {
        if (bossCheckBoxElement.checked) {
            let [bossName, level] = bossCheckBoxElement.id.split('-');
            checkedBossList.push({bossName: bossName, level: level});
        }
    }



}


function updateEvents() {
    const events = [
        {
            title: 'dynamic event',
            start: '2025-05-10',
            end: '2025-05-10',
            type: 'boss-drop',
            icon: 'https://open.api.nexon.com/static/maplestory/item/icon/KEPDJALG',
            allDay: true
        }
    ];

    calendar.addEvent({
        title: 'dynamic event',
        start: '2025-05-10',
        end: '2025-05-10',
        type: 'boss-drop',
        icon: 'https://open.api.nexon.com/static/maplestory/item/icon/KEPDJALG',
        allDay: true
    });

}


window.onload = loadDiaryData;
