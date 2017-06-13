import React from 'react';
import render from 'react-dom';
import App from './containers/App';
import './index.css';
import createStore from './store/store';
import {Provider} from 'react-redux';

let store = createStore();

render(
    <Provider store = {store}>
        <App />
    </Provider>,
  document.getElementById('root')
);
