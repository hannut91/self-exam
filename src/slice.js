import { createSlice } from '@reduxjs/toolkit';

import {
  addQuestion,
  getQuestions,
  removeQuestion,
} from './services/question.service';

const { actions, reducer } = createSlice({
  name: 'app',
  initialState: {
    isAdding: false,
    questions: [],
  },
  reducers: {
    toggleIsAdding: (state) => ({ ...state, isAdding: !state.isAdding }),
    createQuestion: (state, { payload }) => {
      addQuestion(payload);
      const questions = getQuestions();
      return {
        ...state,
        questions,
      };
    },
    fetchQuestions: (state) => ({ ...state, questions: getQuestions() }),
    deleteQuestion: (state, { payload: id }) => {
      removeQuestion(id);
      const questions = getQuestions();
      return {
        ...state,
        questions,
      };
    },
  },
});

export const {
  toggleIsAdding,
  createQuestion,
  fetchQuestions,
  deleteQuestion,
} = actions;

export default reducer;
