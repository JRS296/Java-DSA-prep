var randfloat = Math.random();

var typingTimer; // timer identifier
var doneTypingInterval = 500; // time in ms (0.5 seconds)

function search_ajax_call() {
    // initiate cached results if not
    var val = $('#searchbar-input').val();
    if (!is_user_logged_in && val.length === 0) {
        $('#search-dropdown').hide();
        return;
    }

    if (!window.cached_search_results) {
        window.cached_search_results = {};
    }
    // checking when to show 'Retrieving suggestions'
    // case 1: when chars are being typed in search-input and search is in progress
    // at that instant dropdown contains no results but only a hidden anchor link
    // case 2: when an error message is in dropdown and on backspace keyup it
    // should get replaced with 'Retrieving suggestions'

    var dropdownChildren = $('#search-dropdown').children();
    var numChildren = dropdownChildren.length;

    if ((numChildren === 1 && $(dropdownChildren[0]).is(":hidden")) ||
        $('#search-dropdown').find('.no-results').length > 0) {
        $('#search-dropdown').html("" +
            '<div class="result-wrapper-banner1"></div>' +
            '<div class="result-wrapper-banner2"></div>' +
            '<div class="result-wrapper-container">' +
            "<div id='results-more' class='result-wrapper'>" +
            "<div class='text-div no-results'>" +
            "<div id='text' class='bold float-left'> Retrieving" +
            " suggestions </div>" +
            "<div id='image' class='dots-loader float-left'></div>" +
            " <div class='clear'></div>" +
            "</div>" +
            "</div>" +
            "</div>").show();
    } else {
        var resultsMore = $('#results-more');
        resultsMore.find('#search-more').hide();
        resultsMore.show();
        resultsMore.find('.no-results').show();
    }

    function handle_ajax_response(data, method) {
        if (method === 'success') {
            var rTime = this.id;
        } else {
            var rTime = $.now();
        }
        var searchDropdown = $('#search-dropdown');
        var dataTime = searchDropdown.attr('timestamp');
        if (dataTime === undefined || dataTime < rTime) {
            data.html = $.trim(data.html);
            searchDropdown.html(data.html);
            if (data.html.length > 0) {
                searchDropdown.show();
                setFirstResultFocused();
            } else {
                searchDropdown.hide();
            }
            $('#results-more .no-results').hide();
            $('#results-more #search-more').show();

            searchDropdown.attr('timestamp', rTime);
            // cache results in browser.
            window.search_suggestions_data = data;
        }
        // cache search result
        window.cached_search_results[val] = data;
        //window.xhr = false;
    }

    if (val in window.cached_search_results) {
        handle_ajax_response(window.cached_search_results[val]);
        return true;
    } else {

        // Preventing the triggering of the same request on focus.
        if (window.previousVal && val === window.previousVal) {
            return;
        }

        // Cancelling the previous unnecessary request.
        if (window.previousVal && window.previousVal.length > 0) {

            if (window.previousRequest) {
                window.isAborted = true
                window.previousRequest.abort();
            }
        }

        window.previousVal = val;
        window.previousRequest = $.ajax({
            url: $('#searchbar-input').attr('ajax1'),
            type: "GET",
            data: { 'q': val, 'randfloat': randfloat, 'search_type':'candidate' },
            id: $.now(),
            cache: true,
        }).done(handle_ajax_response).fail(function() {

            // When the request is intentionally aborted don't show the error message
            // returning from here
            if (window.isAborted) {
                window.isAborted = false
                return;
            }
            $('#search-dropdown').html("" +
                '<div class="result-wrapper-banner1"></div>' +
                '<div class="result-wrapper-banner2"></div>' +
                '<div class="result-wrapper-container">' +
                "<div id='results-more' class='result-wrapper'>" +
                "<div class='text-div no-results request-timeout'>" +
                "<div id='text' class='bold float-left'>Something " +
                "went wrong please try again!</div>" +
                " <div class='clear'></div>" +
                "</div>" +
                "</div>" +
                "</div>").show();
            //window.xhr = false;
        });
    }
}

$('#searchbar-input').on('keyup', function(e) {
    clearTimeout(typingTimer);

    var url_suggestions = $(this).attr('ajax1');
    var val = $(this).val();

    var c = String.fromCharCode(e.keyCode);
    var isWordcharacter = c.match(/\w/);
    // ignore if the key was not alpha-numeric and not down key
    if (!isWordcharacter && !(e.keyCode === 40) && !(e.keyCode === 13) &&
        !(e.keyCode === 8) && !(e.keyCode === 27)) {
        //console.log('input element key handled');
        return true;
    }
    // hide dropdown if key was escape
    if (e.keyCode === 27) {
        $(this).blur();
        $('#search-dropdown').hide();
        return true;
    }
    // if its the down key or enter key and the results are not visible, see if results are cached.
    // if yes, then show them
    else if (e.keyCode === 40 || e.keyCode === 13) {
        if (window.search_suggestions_data &&
            $('#search-dropdown').css('display') === "none") {
            $('#search-dropdown').show();
            // reset focused to the first result element
            $('.focused').removeClass('focused');
            $(".result-wrapper").first().addClass('focused');
        }
        return true;
    }

    typingTimer = setTimeout(search_ajax_call, doneTypingInterval);
});

// navigation on dropdown
$('#searchbar-input').on('keydown', function(e) {
    //console.log("input");
    clearTimeout(typingTimer);
    dropdown(e);
});

var dropdown = function(e) {
    if ($('#search-dropdown').css('display') === "none") {
        return false;
    }
    //right
    if (e.keyCode === 39) {
        var q = $('.focused').find('a').attr('data-q');
        $('#searchbar-input').focus().val(q);
        search_ajax_call();
    }
    //down
    if (e.keyCode === 40) {
        var $focused = $('.focused');
        var $results = $(".result-wrapper:not(:hidden)");
        if ($focused.length < 1) {
            // put the focus on first search result
            $results.first().addClass('focused');
        } else {
            // shift focus to next result
            var index = $focused.index();
            var next_ind = (index + 1) % $results.length;
            $focused.toggleClass('focused');
            $($results[next_ind]).toggleClass('focused');
        }
        return true;
    }
    //up
    if (e.keyCode === 38) {
        var $focused = $('.focused');
        var $results = $(".result-wrapper:not(:hidden)");
        if ($focused.length < 1) {
            // put the focus on first search result
            $results.last().addClass('focused');
        } else {
            // shift focus to next result
            var index = $focused.index();
            var next_ind = (index - 1);
            if (next_ind < 0) {
                next_ind = $results.length - 1;
            }
            $focused.toggleClass('focused');
            $($results[next_ind]).toggleClass('focused');
        }
        return true;
    }

    // enter key
    if (e.keyCode === 13) {
        var focusedOption = $('.focused').find('a');
        if (typeof focusedOption[0] !== "undefined" && focusedOption.length > 0) {
            var q = focusedOption.attr('data-q');
            $('#searchbar-input').focus().val(q);
            focusedOption[0].click();
        }
    }
};

// hide dropdown if user clicks anywhere on the page
$('body').mouseup(function(e) {
    if ($(e.target).parents('#search-dropdown').length === 0 && $(
            e.target).parents('#searchbar-input').length === 0 &&
        (!$('#searchbar-input').is(':focus'))) {
        $("#search-dropdown").hide();
    }
});

// focus the results on mouseover event
$('.result-wrapper').on('mouseover', function() {
    $('.focused').removeClass('focused');
    $(this).addClass("focused");
});

// remove the focus on mouseout event
$('.result-wrapper').on('mouseout', function() {
    $(this).removeClass("focused");
});

// search page if click on search icon
$('#searchbar #search-icon-container').on('click', function() {
    if ($('#searchbar-input').val().length > 0) {
        var href = $('#url_search_page').attr('href');
        if (href != undefined) {
            href = href + "?q=" + $('#searchbar-input').val();
            window.location = href;
        }
    }
    return false;
});

// focus on searchbar if '/' is pressed
$(document).on('keyup', function(e) {
    var input = $('#searchbar-input');
    if ($(':focus').length === 0 && e.keyCode === 191) {
        input.focus().val(input.val());
    }
});

// show dropdown on focus on searchbar
$('#searchbar-input').on('focus', function() {
    search_ajax_call();
    if ($('#searchbar-input').val().length > 0 &&
        $('#search-dropdown').html().length > 0) {
        $('#search-dropdown').show(0, setFirstResultFocused);
    }
});

// set focus on first search result
function setFirstResultFocused() {
    var focused_div = $('#search-dropdown').find('.focused');
    if (focused_div.length === 0) {
        var first_result = $('#search-dropdown').find('.result-wrapper').first();
        if (first_result && !first_result.hasClass('no-results'))
            first_result.addClass('focused');
    }
}