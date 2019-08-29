function getFile(){
var id= $('#id').val()
$.ajax({
    url: '/files/file/'+id,
    type: 'POST',
    success: function() {
        alert ("File saved successufully!");
    }
});
}