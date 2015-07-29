$(document).ready(function(){

    $(function(){
        $('#update_button').on('click', function(){
            var value=$(this).val();
            console.log(value);
            $.ajax({
                url: '/web/updateController' + value,
            })
        })
    });

});
