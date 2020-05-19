import axios from 'axios';
import url from 'url';

import { SERVER_URL } from '../config';

export const getQuestions = async () => {
  const { data } = await axios.get(url.resolve(SERVER_URL, '/questions'));
  return data;
};

export const getCorrects = async ({ questionId, answers }) => {
  const endpoint = url.resolve(SERVER_URL, `/questions/${questionId}/corrects`);
  const params = {
    words: Object.keys(answers).map((it) => ({ id: it, word: answers[it] })),
  };
  const { data } = await axios.post(endpoint, params);
  return {
    questionId,
    corrects: data,
  };
};
