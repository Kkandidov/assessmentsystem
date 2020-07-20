$().ready(function () {

    $(document).on('change', '#themes', function () {
        let topicId = $(this).val();

        $.getJSON(window.contextRoot + '/user/topic/' + topicId + '/tests', function (data) {
            $("#testNames").html('');
            $.each(data, function () {
                $("#testNames").append('<option value="' + this.id + '">' + this.name + '</option>');
            });
        });
    });

    $("#testId").on('click', function () {
        let id = $("#testNames option:selected").val();
        location.href = window.contextRoot + '/user/chosen/test?testId=' + id;
        return false;
    });

    $(function(){
        window.setTimeout(function(){
            $('#message').alert('close');
        },1500);
    });

    $(function(){
        window.setTimeout(function(){
            $('#logout').alert('close');
        },1500);
    });

});