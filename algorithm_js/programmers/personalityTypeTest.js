const mapToResult = (choiceMap) => {
  let result = '';

  if (choiceMap.get('R') >= choiceMap.get('T')) result += 'R';
  else result += 'T';

  if (choiceMap.get('C') >= choiceMap.get('F')) result += 'C';
  else result += 'F';

  if (choiceMap.get('J') >= choiceMap.get('M')) result += 'J';
  else result += 'M';

  if (choiceMap.get('A') >= choiceMap.get('N')) result += 'A';
  else result += 'N';

  return result;
};

const solution = (survey, choices) => {
  const NEUTRAL = 4;
  const questionLen = choices.length;
  const types = ['R', 'T', 'C', 'F', 'J', 'M', 'A', 'N'];
  const choiceMap = new Map();

  for (let type of types) {
    choiceMap.set(type, 0);
  }

  for (let i = 0; i < questionLen; i++) {
    const choice = choices[i];

    if (choice === NEUTRAL) {
      continue;
    } else if (choice < 4) {
      const disagree = survey[i][0];
      choiceMap.set(disagree, choiceMap.get(disagree) + (NEUTRAL - choice));
    } else {
      const agree = survey[i][1];
      choiceMap.set(agree, choiceMap.get(agree) + (choice - NEUTRAL));
    }
  }
  return mapToResult(choiceMap);
};

//   solution(['AN', 'CF', 'MJ', 'RT', 'NA'], [5, 3, 2, 7, 5]);
