$(function(){
    var callJson = function(method, json, id, callback){
        $.ajax({
               type: method,
               url: 'http://localhost:8080/workshopsmodule5_war_exploded/books/' + id,
               data: json,
               dataType : "json",
               contentType: "application/json"
        }).done(function(result){
            callback(result);
        });
    }
    var table = $("ul");
    callJson("GET","","",function(result){
        for(var i = 0; i < result.length; i++){

            var newLi = $("<li>");
            newLi.text(result[i].title);
            newLi.data("id", result[i].id);
            table.append(newLi);

            var newDiv = $("<div>");
            table.append(newDiv);

            var newButton = $("<button>Usuń</button>");
            newButton.data("id", result[i].id);
            table.append(newButton);
        }
    });
    table.on("click", "li", function(){
        var id = $(this).data("id");
        var div = $(this).next();
        callJson("GET","",id,function(result){
            div.text("Author: " + result.author +
                     ", isbn: " + result.isbn);
        })
    });

    table.on("click", "button", function(){
        var id = $(this).data("id");
        callJson("DELETE","",id,function(result){
            location.reload();
        })
    });

    $('form').on('submit', function (e) {
        e.preventDefault();
        var newBook = {};
        newBook.title = $('form').find("input[name='title'").val();
        newBook.isbn= $('form').find("input[name='isbn'").val();
        newBook.author= $('form').find("input[name='author'").val();
        newBook.publisher= $('form').find("input[name='publisher'").val();
        newBook.type= $('form').find("input[name='type'").val();
        callJson('post', JSON.stringify(newBook), "", function(){
            alert("u mnie działa");
            location.reload();
        });
    })
})