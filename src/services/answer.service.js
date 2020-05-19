import axios from 'axios';
import url from 'url';

import { SERVER_URL } from '../config';

export const getAnswers = async (questionId) => {
  const endpoint = url.resolve(SERVER_URL, `/answers/${questionId}`);
  const { data } = await axios.get(endpoint);

  return {
    questionId,
    answers: data,
  };
};
