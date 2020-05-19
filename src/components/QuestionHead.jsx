import React from 'react';

import { useDispatch } from 'react-redux';

import ListItem from '@material-ui/core/ListItem';
import ListItemText from '@material-ui/core/ListItemText';
import ExpandLess from '@material-ui/icons/ExpandLess';
import ExpandMore from '@material-ui/icons/ExpandMore';

import { fetchAnswers, toggleQuestion } from '../slice';

export default function QuestionHead({ question }) {
  const dispatch = useDispatch();

  const toggle = () => {
    if (!question.answers) {
      dispatch(fetchAnswers(question.id));
    }

    dispatch(toggleQuestion(question.id));
  };

  return (
    <ListItem button onClick={toggle}>
      <ListItemText primary={question.question} />
      {question.open ? <ExpandLess /> : <ExpandMore />}
    </ListItem>
  );
}
