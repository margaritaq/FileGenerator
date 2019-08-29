function downloadFile(){
var id= $('#id').val()
$.ajax({
    url: '/files/'+id,
    type: 'POST',
    success: function() {
        alert ("File saved successufully!");
    }
});
}