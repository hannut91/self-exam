import { createSlice, createAsyncThunk } from '@reduxjs/toolkit';

import {
  getQuestions, getCorrects,
} from './services/question.service';
import { getAnswers } from './services/answer.service';

export const fetchQuestions = createAsyncThunk('fetchQuestions',
  async () => await getQuestions());

export const fetchAnswers = createAsyncThunk('fetchAnswers',
  async (questionId) => await getAnswers(questionId));

export const fetchCorrects = createAsyncThunk(
  'fetchCorrects', async ({ questionId, answers }) => await getCorrects({ questionId, answers }),
);

const { actions, reducer } = createSlice({
  name: 'app',
  initialState: {
    isAdding: false,
    questions: [],
  },
  reducers: {
    toggleQuestion: (state, { payload }) => ({
      ...state,
      questions: state.questions.map((it) => (it.id === payload ? { ...it, open: !it.open } : it)),
    }),
  },
  extraReducers: {
    [fetchQuestions.fulfilled]: (state, { payload: questions }) => ({
      ...state,
      questions,
    }),
    [fetchAnswers.fulfilled]: (state, { payload }) => ({
      ...state,
      questions: state.questions.map((it) => (
        it.id === payload.questionId
          ? { ...it, answers: payload.answers }
          : it)),
    }),
    [fetchCorrects.fulfilled]: (state, { payload }) => {
      const { questionId, corrects } = payload;

      return {
        ...state,
        questions: state.questions.map((question) => {
          if (question.id !== questionId) {
            return question;
          }

          return {
            ...question,
            answers: question.answers.map((answer) => {
              const correct = corrects.find((it) => it.wordId === answer.wordId);
              if (!correct) {
                return answer;
              }

              return {
                ...answer,
                word: correct.word,
                isCorrect: correct.isCorrect,
              };
            }),
          };
        }),
      };
    },
  },
});

export const {
  toggleIsAdding,
  createQuestion,
  deleteQuestion,
  toggleQuestion,
} = actions;

export default reducer;
