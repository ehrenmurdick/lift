(function($) {
  $.fn.methodone = function() {
    $(this).click(function() {
      var $this  = $(this),
          form   = $('<form/>');

      form.attr({
        method: $this.data('method'),
        action: $this.attr('href')
      });

      form.submit();
    });
  }

  $(function() {
    $('a[data-method=put],a[data-method=post],a[data-method=delete]').methodone();
  });
})(jQuery);
