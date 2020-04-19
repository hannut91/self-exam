import React from 'react';

import { useSelector, useDispatch } from 'react-redux';

import AddIcon from '@material-ui/icons/Add';
import IconButton from '@material-ui/core/IconButton';

import CreateQuestion from './CreateQuestion';

import { toggleIsAdding } from '../slice';

const styles = {
  center: {
    textAlign: 'center',
  },
};

const AddButton = () => {
  const isAdding = useSelector((state) => state.isAdding);
  const dispatch = useDispatch();

  return (
    <div>
      {isAdding
        ? <CreateQuestion />
        : (
          <div css={styles.center}>
            <IconButton onClick={() => dispatch(toggleIsAdding())} aria-label="add" color="primary">
              <AddIcon />
            </IconButton>
          </div>
        )}
    </div>
  );
};

export default AddButton;
