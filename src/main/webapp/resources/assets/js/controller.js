function getPictureUrl(category) {
    switch(category) {
        case "Крупная бытовая техника": return "/resources/pictures/Krupno-byitovaya-tehnika-KBT.jpg";
        case "Холодильники": return "/resources/pictures/Holodilniki.jpg";
        case "Стиральные машины": return "/resources/pictures/stiralniye_mashiny.jpg";
        case "Газовые плиты": return "/resources/pictures/gazoviye_plity.jpg";
        case "Мелкая бытовая техника": return "/resources/pictures/melkaya_bytovaya_technika.png";
        case "Пылесосы": return "/resources/pictures/pilesosy.jpg";
        case "Электрочайники": return "/resources/pictures/elektrochayniki.jpg";
        case "Телевизоры и аксессуары": return "/resources/pictures/Televisory_i_aksessuary.jpg";
        case "Телевизоры": return "/resources/pictures/Televizory.jpg";
        case "Акустика Hi-Fi": return "/resources/pictures/Akkustika_Hi-Fi.jpg";
        case "Домашние кинотеатры": return "/resources/pictures/domashniye_Kinoteatry.jpg";
        case "DVD/HD-медиаплееры": return "/resources/pictures/DVD_HD.jpg";
        case "Аксессуары": return "/resources/pictures/acessorios.jpg";
        default: return "/resources/pictures/bytovaya-technika.jpg";
    }
}

function createCell(val) {
    return '<div class="col-sm-6 col-md-4"><div class="thumbnail"><img src="'+ getPictureUrl(val.category) +'"/><div class="caption"><h3>'+ val.name + '</h3><p>'+ val.description + '</p>' + '<p>' + val.price + "UAH" + '</p>' + createBungle(val.available) + '<div/><div/>';
}

function createBungle(isAvailable) {
    if(isAvailable) {
        return '<span class="label label-success">Available</span>';
    } else {
        return '<span class="label label-danger">Not available</span>';

    }
}

function createNewElement(i, val) {
    if (i%3==0) {
     return $('<div class="row">' +
              + createCell(val));
    } else if (i%3==2) {
     return $(createCell(val) +
                    '<div/>');
    } else {
    return $(createCell(val));
}
}

function getAllProducts() {
    $.ajax({
    url : '/products',
    type: 'GET',
    dataType: 'json',
    contentType: 'application/json',
    mimeType: 'application/json',
    data : ({
     }),
     success: function (data) {
     var $newdiv1;
         $.each(data, function(i, val) {
                  console.log(i);
         console.log(val);
              existingdiv1 = document.getElementById( "product--list" );
              if($newdiv1){
                $newdiv1 = createNewElement(i, val);
              } else {
                $newdiv1 = $newdiv1 + createNewElement(i, val);
              }
              console.log($newdiv1);
         });
         newdiv2 = document.createElement( "div" );
                          $("body").append( $newdiv1, [ newdiv2, existingdiv1 ] );
     }
   });
}


$(document).ready(getAllProducts());
