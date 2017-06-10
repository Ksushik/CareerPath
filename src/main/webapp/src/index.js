import React from 'react';
import ReactDOM from 'react-dom';
import App from './containers/App';
import './index.css';
import {createStore} from 'redux';
import {Provider} from 'react-redux';


const store = createStore (() => {}, {});

ReactDOM.render(
  <App />,
  document.getElementById('app')
);
