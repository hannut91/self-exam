import React from 'react';
import ReactDOM from 'react-dom';

import { Provider } from 'react-redux';

import store from './store';

import ConfirmServiceProvider from './providers/ConfirmServiceProvider';
import App from './App';

ReactDOM.render(
  <Provider store={store}>
    <ConfirmServiceProvider>
      <App />
    </ConfirmServiceProvider>
  </Provider>,
  document.getElementById('app'),
);
