const getNextId = () => {
  const id = localStorage.getItem('nextId');
  if (!id) {
    localStorage.setItem('nextId', '2');
    return 1;
  }

  localStorage.setItem('nextId', (Number(id) + 1).toString());
  return Number(id);
};

export const getQuestions = () => {
  const questions = localStorage.getItem('questions');
  if (!questions) {
    return [];
  }

  return JSON.parse(questions);
};

export const addQuestion = (question) => {
  const nextId = getNextId();

  const questions = getQuestions();
  localStorage.setItem('questions', JSON.stringify([...questions, {
    id: nextId,
    ...question,
  }]));
};

export const removeQuestion = (id) => {
  const questions = getQuestions();

  localStorage.setItem('questions', JSON.stringify(
    questions.filter((it) => it.id !== id),
  ));
};
