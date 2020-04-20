import React, { useEffect, useState, useContext } from 'react';

import { useDispatch } from 'react-redux';

import Collapse from '@material-ui/core/Collapse';
import ListItem from '@material-ui/core/ListItem';
import ListItemText from '@material-ui/core/ListItemText';
import ExpandLess from '@material-ui/icons/ExpandLess';
import ExpandMore from '@material-ui/icons/ExpandMore';
import Button from '@material-ui/core/Button';

import { deleteQuestion } from '../slice';

import { ConfirmContext } from '../providers/ConfirmProvider';

const styles = {
  description: {
    padding: '16px 16px 16px 24px',
  },
};

const Question = (props) => {
  const { question } = props;
  const confirm = useContext(ConfirmContext);
  const dispatch = useDispatch();
  const [q, setQuestion] = useState({});

  useEffect(() => {
    setQuestion({ ...question, open: false });
  }, []);

  const toggle = () => {
    setQuestion({ ...q, open: !q.open });
  };

  const onDelete = async (id) => {
    const confirmed = await confirm({
      title: '주의',
      description: '삭제하시겠습니까?',
    });
    if (!confirmed) {
      return;
    }

    dispatch(deleteQuestion(id));
  };

  return (
    <>
      <ListItem button onClick={toggle}>
        <ListItemText primary={q.question} />
        {q.open ? <ExpandLess /> : <ExpandMore />}
      </ListItem>

      <Collapse in={q.open}>
        <div css={styles.description}>
          {q.answer}
        </div>

        <div>
          <Button
            onClick={() => onDelete(question.id)}
            color="secondary"
            type="button"
          >
            삭제
          </Button>
        </div>
      </Collapse>
    </>
  );
};

export default Question;
