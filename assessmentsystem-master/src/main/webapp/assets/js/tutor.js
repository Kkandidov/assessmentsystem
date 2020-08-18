$().ready(function () {
    $(document).on('change', '#topics', function () {
        let topicId = $(this).val();

        $.getJSON(window.contextRoot + '/tutor/tutor-test/' + topicId + '/tests', function (data) {
            $("#tests").html('');
            $("#tests").append("<option value='' disabled selected> Выберите тест</option>");
            $.each(data, function () {
                $("#tests").append('<option value="' + this.id + '">' + this.name + '</option>');
            });
        });
    });


    $("#test").on('click', function () {
        let id = $("#tests option:selected").val();
        if (id === undefined) {
            location.href = window.contextRoot + '/tutor/tutor-test?error';
        } else {
            location.href = window.contextRoot + '/tutor/test/' + id;
        }
    });

});



