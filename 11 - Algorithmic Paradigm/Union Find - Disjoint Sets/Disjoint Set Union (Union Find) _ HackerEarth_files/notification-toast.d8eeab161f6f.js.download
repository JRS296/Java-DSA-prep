// This file is dependent on notification_toast.html.
typeof $ !== "undefined" &&
  $(document).ready(function() {
    /* Calculate top position of error based on end test alert */
    function setTopPositionOfError() {
      var notificationContainer = $(".notification-toast-container");
      var endTestAlert = $("#end-test-alert-message");
      if (endTestAlert.length > 0) {
        var topPosition =
          endTestAlert.offset().top + endTestAlert.height() + 10;
        if (endTestAlert.is(":visible")) {
          notificationContainer.css("top", topPosition);
        } else {
          notificationContainer.css("top", "");
        }
      }
    }

    window.global = {};

    /* Check if a string/number starts with a given digit */
    window.global.checkIfIStartWith = function checkIfIStartWith(
      digit,
      content
    ) {
      return ("" + content).indexOf(digit) === 0;
    };

    window.global.showAppropriateError = function(idOfError, customMessage) {
      var notificationErrors = $(".notification-errors");
      var activeErrorItem = notificationErrors.find(idOfError);

      // Set custom message if available to respective activeErrorItem
      if (customMessage || typeof customMessage !== "undefined") {
        activeErrorItem = notificationErrors.find("#notification-custom-error");
        activeErrorItem.text(customMessage);
      }
      // Fallback error item
      if (activeErrorItem.length === 0) {
        activeErrorItem = notificationErrors.find("#notification-error");
      }

      setTopPositionOfError();
      // Hide all errors
      notificationErrors.find(".error-item").addClass("hidden");
      // Show relevant error
      activeErrorItem.removeClass("hidden");

      // Remove the notification after 10 seconds
      setTimeout(function() {
        activeErrorItem.addClass("hidden");
      }, 10000);
    };

    /* Handler to check for all 5XX errors */
    window.global.checkAndShowServerError = function(status) {
      if (window.global.checkIfIStartWith(5, status)) {
        window.global.showAppropriateError("#notification-server-error");
      }
    };

    $(document).ajaxError(function(event, jqXHR) {
      var responseStatusCode = jqXHR.status;
      if (responseStatusCode === 403) {
        /* Auth error */
        window.global.showAppropriateError("#notification-auth-error");
      } else if (window.global.checkIfIStartWith(4, status)) {
        /* All remaining 4XX errors */
        window.global.showAppropriateError();
      }
    });

    function checkToShowPersistantNotification() {
      var cookies = document.cookie;
      var cookieArray = cookies.split(";");
      var showNotification = true;
      for (var index = 0; index < cookieArray.length; index++) {
        if (
          cookieArray[index].split("=")[0].trim() ===
          "show_persistant_notification"
        ) {
          showNotification = cookieArray[index].split("=")[1] === "true";
        }
      }
      return showNotification;
    }

    function getExpiryDate() {
      return new Date(2019, 0, 30, 9, 0, 0, 0).toUTCString();
    }

    (function() {
      var showNotification = checkToShowPersistantNotification();
      if (showNotification) {
        var persistantNotification = $("#persistant-notification");
        persistantNotification.removeClass("hidden");
      }

      $("#persistant-notification .close-icon").on("click", function() {
        $("#persistant-notification").addClass("hidden");
        var expires = "expires=" + new Date(getExpiryDate()).toGMTString();
        document.cookie =
          "show_persistant_notification=false; " + expires + "; path=/";
      });
    })();

    // To display event announcements using `localstorage`
    var announcementContainer = $(".persistant-notification.info-notification");
    // `eventName` is used as the value for local storage. In case of new announcement change this.
    // SM-02072019 = Scheduled maintenance on July 2 2019
    // PRODUCT-WEB-FEB = Feb webinar
    // SM-11122020 = Scheduled maintenance on December 11 2020
    // SM-06102021 = Developer recruitment survey 2021
    // SM-13102021 = It pays to share your opinions
    // var eventName = "SM-13102021";
    // SM-29112021 = Developer recruitment survey report 2021
    // ANUAL-SURVEY-19-SEP-2022
    var eventName = "ANUAL-SURVEY-19-SEP-2022";

    if (
      localStorage &&
      localStorage.getItem("announcement-seen") === eventName
    ) {
      announcementContainer.addClass("hidden");
    } else {
      announcementContainer.removeClass("hidden");
    }

    $("#close-icon-announcement").on("click", function() {
      announcementContainer.addClass("hidden");

      if (window.localStorage) {
        try {
          localStorage.setItem("announcement-seen", eventName);
        } catch (e) {
          if (typeof Sentry !== 'undefined'){
            Sentry.withScope(function(scope) {
              scope.setExtra('origin', "event announcement toast");
              Sentry.captureException(e);
            });
          }
        }
      }
    });
  });
