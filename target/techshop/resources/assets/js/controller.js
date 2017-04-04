function getPictureUrl(category) {
  switch (category) {
    case "Крупная бытовая техника":
      return "/resources/pictures/Krupno-byitovaya-tehnika-KBT.jpg";
    case "Холодильники":
      return "/resources/pictures/Holodilniki.jpg";
    case "Стиральные машины":
      return "/resources/pictures/stiralniye_mashiny.jpg";
    case "Газовые плиты":
      return "/resources/pictures/gazoviye_plity.jpg";
    case "Мелкая бытовая техника":
      return "/resources/pictures/melkaya_bytovaya_technika.png";
    case "Пылесосы":
      return "/resources/pictures/pilesosy.jpg";
    case "Электрочайники":
      return "/resources/pictures/elektrochayniki.jpg";
    case "Телевизоры и аксессуары":
      return "/resources/pictures/Televisory_i_aksessuary.jpg";
    case "Телевизоры":
      return "/resources/pictures/Televizory.jpg";
    case "Акустика Hi-Fi":
      return "/resources/pictures/Akkustika_Hi-Fi.jpg";
    case "Домашние кинотеатры":
      return "/resources/pictures/domashniye_Kinoteatry.jpg";
    case "DVD/HD-медиаплееры":
      return "/resources/pictures/DVD_HD.jpg";
    case "Аксессуары":
      return "/resources/pictures/acessorios.jpg";
    default:
      return "/resources/pictures/bytovaya-technika.jpg";
  }
}

function getCode(category) {
  switch (category) {
    case "Крупная бытовая техника":
      return 1;
    case "Холодильники":
      return 1.1;
    case "Стиральные машины":
      return 1.2;
    case "Газовые плиты":
      return 1.3;
    case "Мелкая бытовая техника":
      return 2;
    case "Пылесосы":
      return 2.1;
    case "Электрочайники":
      return 2.2;
    case "Телевизоры и аксессуары":
      return 3;
    case "Телевизоры":
      return 3.1;
    case "Акустика Hi-Fi":
      return 3.2;
    case "Домашние кинотеатры":
      return 3.3;
    case "DVD/HD-медиаплееры":
      return 3.4;
    case "Аксессуары":
      return 3.5;
    default:
      return 3.6;
  }
}

function createCell(val) {
  return '<div class="col-sm-6 col-md-4"><div class="thumbnail"><img src="' + getPictureUrl(val.category) + '"/><div class="caption"><h3>' + val.name + '</h3><p><b>' + 'Категория товара: ' + val.category + '</b></p>'+ '<p>' + val.description + '</p>' + '<p>' + val.price + "UAH" + '</p>' + createBungle(val.available) + '<div/><div/>';
}

function createBungle(isAvailable) {
  if (isAvailable) {
    return '<span class="label label-success">Available</span>';
  } else {
    return '<span class="label label-danger">Not available</span>';

  }
}

function compare(a, b) {
  if (a.price < b.price) {
    return -1;
  }
  if (a.price > b.price) {
    return 1;
  }
  // a должно быть равным b
  return 0;
}


function filterByPrice(element) {
  $("#product--list").empty();
  if (element.checked) {
    $.ajax({
      url: '/products',
      type: 'GET',
      dataType: 'json',
      contentType: 'application/json',
      mimeType: 'application/json',
      data: ({}),
      success: function (data) {
        var $newdiv1;
        data.sort(compare);
        $.each(data, function (i, val) {
          $("#product--list").append(createCell(val));
        });
      }
    });
  } else {
    getAllProducts();
  }
}

function showOnlyAvailable(element) {
  $("#product--list").empty();
  if (element.checked) {
    $.ajax({
      url: '/products',
      type: 'GET',
      dataType: 'json',
      contentType: 'application/json',
      mimeType: 'application/json',
      data: ({}),
      success: function (data) {
        var $newdiv1;
        $.each(data, function (i, val) {
          if (val.available) {
            $("#product--list").append(createCell(val));
          }
        });
      }
    });
  } else {
    getAllProducts()
  }
}


$('.manufacturer').on('change', function () {
  var selected = $(this).val();
  $("#product--list").empty();
  $.ajax({
    url: '/products',
    type: 'GET',
    dataType: 'json',
    contentType: 'application/json',
    mimeType: 'application/json',
    data: ({}),
    success: function (data) {
      var $newdiv1;
      $.each(data, function (i, val) {
        if (selected.includes(val.manufacturer)) {
          $("#product--list").append(createCell(val));
        }
      });
    }
  });
});


$('.category').on('change', function () {
  var selected = $(this).val();
  $("#product--list").empty();
  $.ajax({
    url: '/products',
    type: 'GET',
    dataType: 'json',
    contentType: 'application/json',
    mimeType: 'application/json',
    data: ({}),
    success: function (data) {
      var $newdiv1;
      $.each(data, function (i, val) {
        if (selected.includes(val.category)) {
          $("#product--list").append(createCell(val));
        }
      });
    }
  });
});


function getAllCategories() {
  $.ajax({
    url: '/products/categories',
    type: 'GET',
    dataType: 'json',
    contentType: 'application/json',
    mimeType: 'application/json',
    data: ({}),
    success: function (data) {
      $.each(data, function (i, val) {
        $("#category").append('<option value="' + val.name + '" selected="">' + val.name + '</option>');
        $("#category").selectpicker("refresh");
      });
    }
  });
}

function getAllManufacturers() {
  $.ajax({
    url: '/products/manufacturers',
    type: 'GET',
    dataType: 'json',
    contentType: 'application/json',
    mimeType: 'application/json',
    data: ({}),
    success: function (data) {
      $.each(data, function (i, val) {
        $("#manufacturer").append('<option value="' + val.name + '" selected="">' + val.name + '</option>');
        $("#manufacturer").selectpicker("refresh");
      });
    }
  });
}

function getAllProducts() {
  $.ajax({
    url: '/products',
    type: 'GET',
    dataType: 'json',
    contentType: 'application/json',
    mimeType: 'application/json',
    data: ({}),
    success: function (data) {
      var $newdiv1;
      $.each(data, function (i, val) {
        $("#product--list").append(createCell(val));
      });
    }
  });
}

function deleteCategory(element) {
  var categoryName = $(element).parent().parent()[0].childNodes[1].childNodes[1].childNodes[0];
  $.ajax({
    url: '/products/categories/del/' + getCode(categoryName.nodeValue.toString()),
    type: 'POST',
    dataType: 'json',
    contentType: 'application/json',
    mimeType: 'application/json',
    // data: ({"categoryCode": getCode(categoryName.nodeValue.toString())}),
  });

  getAllCategories();
}


$(document).ready(getAllCategories(), getAllManufacturers(), getAllProducts());
