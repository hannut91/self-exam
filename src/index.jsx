import React from 'react';
import ReactDOM from 'react-dom';

import { Provider } from 'react-redux';

import store from './store';

import ConfirmProvider from './providers/ConfirmProvider';

import App from './App';

ReactDOM.render(
  <Provider store={store}>
    <ConfirmProvider>
      <App />
    </ConfirmProvider>
  </Provider>,
  document.getElementById('app'),
);
