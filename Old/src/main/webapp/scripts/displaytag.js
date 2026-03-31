
// duplicate and add extra exportlinks element on top of display table 
$(function() {

    var export1 = $('.exportlinks');
    if (export1 != null) {

        // duplication
        var export2 = export1.clone();
        var topPagebanner = $('.pagebanner:first-of-type');
        topPagebanner.before(export2);
    }
});