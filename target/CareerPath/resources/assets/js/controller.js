import React from 'react';
import {render} from 'react-dom';


function getAllCategories() {
  $.ajax({
    url: '/skills/categories',
    type: 'GET',
    dataType: 'json',
    contentType: 'application/json',
    mimeType: 'application/json',
    data: ({}),
    success: function (data) {
      $.each(data, function (i, val) {
      console.log(data);
        $("#container").append('<option value="' + val.name + '" selected="">' + val.name + '</option>');
        $("#container").selectpicker("refresh");
      });
    }
  });
}



$(document).ready(getAllCategories());

ReactDOM.render(
React.createElement('h1', null, 'Hello, world!'),
document.getElementById('app')
);