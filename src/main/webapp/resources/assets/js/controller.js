
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
        $("#container").append('<option value="' + val.name + '" selected="">' + val.name + '</option>');
        $("#container").selectpicker("refresh");
      });
    }
  });
}



$(document).ready(getAllCategories());
