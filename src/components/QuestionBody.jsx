import React, { useState } from 'react';

import Collapse from '@material-ui/core/Collapse';
import Button from '@material-ui/core/Button';
import TextField from '@material-ui/core/TextField';

import { useDispatch } from 'react-redux';
import { fetchCorrects } from '../slice';

const styles = {
  description: {
    padding: '16px 16px 16px 24px',
  },
  answers: {
    lineHeight: '24px',
  },
  answerInput: {
    bottom: '4px',
    '.MuiInputBase-root': {
      backgroundColor: 'white',
      input: {
        padding: '6px 8px',
        width: '100px',
      },
    },
  },
};

export default function QuestionBody({ question }) {
  const [answers, setAnswers] = useState({});
  const dispatch = useDispatch();

  const onChange = (wordId) => (e) => {
    setAnswers({ ...answers, [wordId]: e.target.value });
  };

  const submit = async () => {
    dispatch(fetchCorrects({ questionId: question.id, answers }));
  };

  return (
    <Collapse in={question.open}>
      <div css={styles.description}>
        {question.answers && question.answers
          .map(({
            wordId, answer, isCorrect, word,
          }, index) => (
            <span css={styles.answers} key={index}>
              {wordId !== 0
                && (word || (
                <TextField
                  error={!isCorrect}
                  css={styles.answerInput}
                  onChange={onChange(wordId)}
                  variant="outlined"
                  type="text"
                />
                ))}
              {answer}
            </span>
          ))}
      </div>

      <div>
        <Button
          onClick={() => submit()}
          color="primary"
          type="button"
        >
          확인
        </Button>
      </div>
    </Collapse>
  );
}
