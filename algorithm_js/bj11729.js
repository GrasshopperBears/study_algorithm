const readline = require("readline");
const rl = readline.createInterface({
    input: process.stdin,
    output: process.stdout,
});
let totalMovement = 0;
let saveMovement = [];

rl.on("line", function (line) {
    movePlates(parseInt(line), 1, 3);
    printResult();
    rl.close();
}).on("close", function () {
    process.exit();
});

function movePlates(plateNumber, from, to) {
    totalMovement++;
    if (plateNumber === 1) {
        saveMovement.push([from, to]);
        return;
    }
    const emptyPlace = findEmptyPlace(from, to);
    movePlates(plateNumber - 1, from, emptyPlace);
    saveMovement.push([from, to]);
    movePlates(plateNumber - 1, emptyPlace, to);
}

function findEmptyPlace(x, y) {
    if (x + y === 3) {
        return 3;
    } else if (x + y === 4) {
        return 2;
    } else return 1;
}

function printResult() {
    console.log(totalMovement);
    console.log(
        saveMovement.reduce((acc, cur) => {
            return (acc += `${cur[0]} ${cur[1]}\n`);
        }, "")
    );
}
