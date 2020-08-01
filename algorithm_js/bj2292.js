const readline = require("readline");
const rl = readline.createInterface({
    input: process.stdin,
    output: process.stdout,
});

rl.on("line", function (line) {
    main(line);
    rl.close();
}).on("close", function () {
    process.exit();
});

function main(line) {
    const number = parseInt(line);
    if (number === 1) {
        console.log(1);
        return;
    }
    findDistance(number);
}

function findDistance(number) {
    let currentIndex = [2, 1];
    while (currentIndex[0] <= number) {
        currentIndex[0] += 6 * currentIndex[1];
        currentIndex[1]++;
    }
    console.log(currentIndex[1]);
}
