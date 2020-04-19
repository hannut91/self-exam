import React, {
  createContext, useState, useRef, useContext,
} from 'react';

import ConfirmDialog from '../components/ConfirmDialog';

const ConfirmationServiceContext = createContext();

export const useConfirmation = () => useContext(ConfirmationServiceContext);

export default function ConfirmationServiceProvider({ children }) {
  const [open, setOpen] = useState(false);
  const [options, setOptions] = useState({});

  const awaitingPromiseRef = useRef();

  const openConfirmation = (params) => {
    setOptions(params);
    setOpen(true);
    return new Promise((resolve) => {
      awaitingPromiseRef.current = { resolve };
    });
  };

  const handleClose = () => {
    awaitingPromiseRef.current.resolve(false);

    setOpen(false);
  };

  const handleSubmit = () => {
    awaitingPromiseRef.current.resolve(true);

    setOpen(false);
  };

  return (
    <>
      <ConfirmationServiceContext.Provider value={openConfirmation}>
        {children}
      </ConfirmationServiceContext.Provider>

      <ConfirmDialog
        open={open}
        onSubmit={handleSubmit}
        onClose={handleClose}
        title={options.title}
        description={options.description}
      />
    </>
  );
}
