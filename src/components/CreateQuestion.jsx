import React, { useState } from 'react';

import { useDispatch } from 'react-redux';

import TextField from '@material-ui/core/TextField';
import Button from '@material-ui/core/Button';
import Card from '@material-ui/core/Card';
import CardActionArea from '@material-ui/core/CardActionArea';
import CardActions from '@material-ui/core/CardActions';
import CardContent from '@material-ui/core/CardContent';

import { toggleIsAdding, createQuestion } from '../slice';

const styles = {
  root: {
    marginTop: '8px',
  },
  full: {
    width: '100%',
  },
};

const CreateQuestion = () => {
  const dispatch = useDispatch();
  const [question, setQuestion] = useState('');
  const [answer, setAnswer] = useState('');

  const handleChange = (handler) => (e) => {
    handler(e.target.value);
  };

  const submit = () => {
    dispatch(createQuestion({ question, answer }));
    dispatch(toggleIsAdding());
  };

  return (
    <Card css={styles.root}>
      <CardActionArea>
        <CardContent>
          <TextField
            css={styles.full}
            label="질문"
            multiline
            rowsMax="2"
            value={question}
            onChange={handleChange(setQuestion)}
          />

          <TextField
            css={styles.full}
            label="답변"
            multiline
            rowsMax="2"
            value={answer}
            onChange={handleChange(setAnswer)}
          />
        </CardContent>
      </CardActionArea>
      <CardActions>
        <Button
          onClick={submit}
          color="primary"
          variant="contained"
          type="button"
        >
          확인
        </Button>
        <Button
          onClick={() => dispatch(toggleIsAdding())}
          variant="contained"
          type="button"
        >
          취소
        </Button>
      </CardActions>
    </Card>
  );
};

export default CreateQuestion;
