import React, { createContext, useState, useRef } from 'react';

import ConfirmDialog from '../components/ConfirmDialog';

export const ConfirmContext = createContext();

export default function ConfirmProvider({ children }) {
  const [open, setOpen] = useState(false);
  const [options, setOptions] = useState({});

  const resolverRef = useRef();

  const openConfirmation = (params) => {
    setOptions(params);
    setOpen(true);

    return new Promise((resolve) => {
      resolverRef.current = { resolve };
    });
  };

  const handleClose = () => {
    resolverRef.current.resolve(false);

    setOpen(false);
  };

  const handleSubmit = () => {
    resolverRef.current.resolve(true);

    setOpen(false);
  };

  return (
    <>
      <ConfirmContext.Provider value={openConfirmation}>
        {children}
      </ConfirmContext.Provider>

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
