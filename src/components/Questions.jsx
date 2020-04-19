import React, { useEffect } from 'react';

import { useSelector, useDispatch } from 'react-redux';

import List from '@material-ui/core/List';

import Question from './Question';

import { fetchQuestions } from '../slice';

const styles = {
  root: {
    width: '100%',
    backgroundColor: '#424242',
    color: 'white',
  },
};

const Questions = () => {
  const dispatch = useDispatch();
  const questions = useSelector((state) => state.questions);

  useEffect(() => {
    dispatch(fetchQuestions());
  }, []);

  return (
    <>
      <List
        aria-labelledby="nested-list-subheader"
        css={styles.root}
      >
        {questions.map((it) => <Question question={it} key={it.id} />)}
      </List>
    </>
  );
};

export default Questions;
