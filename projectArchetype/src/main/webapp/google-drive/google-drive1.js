/** ****************** GLOBAL VARIABLES ******************* */
var SCOPES = ['https://www.googleapis.com/auth/drive','profile'];
var CLIENT_ID = '142440927738-ltd3qpdsf7c1pl041kj4e2cuc2ptbabe.apps.googleusercontent.com';
var FOLDER_NAME = "";
var FOLDER_ID = document.getElementById("hformid:idProjet").value;
var FOLDER_PERMISSION = true;
var FOLDER_LEVEL = 0;
var NO_OF_FILES = 1000;
var DRIVE_FILES = [];
var FILE_COUNTER = 0;
var FOLDER_ARRAY = [];
var IDNewFolder;
var newfolder ="jjjjjj";
var idFOLDER = document.getElementById("hformid:idProjet").value;



/** ****************** AUTHENTICATION ******************* */
function checkAuth1() {
    gapi.auth.authorize({
        'client_id': CLIENT_ID,
        'scope': SCOPES.join(' '),
        'immediate': true
    }, handleAuthResult1);
}

// authorize apps
function handleAuthClick1(event) {
    gapi.auth.authorize(
          { client_id: CLIENT_ID, scope: SCOPES, immediate: false },
          handleAuthResult1);
    return false;
}

// check the return authentication of the login is successful, we display the
// drive box and hide the login box.
function handleAuthResult1(authResult) {
    if (authResult && !authResult.error) {
        $("#drive-box1").css("display", "inline-block");
        $("#login-box1").hide();
        showLoading1();
        getDriveFiles1();
    } else {
        $("#login-box1").show();
        $("#drive-box1").hide();
    }
}
/** ****************** END AUTHENTICATION ******************* */


/** ****************** PAGE LOAD ******************* */
$(function(){
	// initiate to reload the google drive files
	$("#button-reload").click(function () {
        showLoading1();
        showStatus1("Loading Google Drive files...");
        getDriveFiles1();
    });
	
	// Initiate the upload button.
	$("#button-upload").click(function () {
        $("#fUpload").click();
    });
	
	// If user has selected a file
	 $("#fUpload").bind("change", function () {
        var uploadObj = $("[id$=fUpload]");
        showLoading1();
        showStatus1("Uploading file in progress...");
        var file = uploadObj.prop("files")[0];
		var metadata = {
			'title': file.name,
			'description': "bytutorial.com File Upload",
			'mimeType': file.type || 'application/octet-stream',
			"parents": [{
				"kind": "drive#file",
				"id": FOLDER_ID
			}]
		};
		var arrayBufferView = new Uint8Array(file);
		var uploadData = new Blob(arrayBufferView, {type: file.type || 'application/octet-stream'});
		showProgressPercentage1(0);

		try{
			var uploader =new MediaUploader({
				file: file,
				token: gapi.auth.getToken().access_token,
				metadata: metadata,
				onError: function(response){
					showErrorMessage1("Error: " + response.error.message);
					$("#fUpload").val("");
					getDriveFiles1();
				},
				onComplete: function(response){
					hideStatus1();
					$("#upload-percentage").hide(1000);
					if(response.error != null){
						showErrorMessage1("Error: " + response.error.message);
						$("#fUpload").val("");
						getDriveFiles1();
					}else{
						showStatus1("Loading Google Drive files...");
						getDriveFiles1();
					}
				},
				onProgress: function(event) {
					showProgressPercentage1(Math.round(((event.loaded/event.total)*100), 0));
				},
				params: {
					convert:false,
					ocr: true
				}
			});
			uploader.upload();
		}catch(exc){
			showErrorMessage1("Error: " + exc);
			$("#fUpload").val("");
			getDriveFiles1();
		}
    });
	
	// initiate the share files button
	$("#button-share").click(function () {
        FOLDER_NAME = "";
        FOLDER_ID = "0B_KzijCYeJPvalRhMFVpYjl2bTA";
        FOLDER_LEVEL = 0;
        FOLDER_ARRAY = [];
        $("#span-navigation1").html("");
        $(this).toggleClass("flash1");
		if($(this).attr("class").indexOf("flash1") >= 0){
			$("#span-sharemode").html("ON");
		}else{
			$("#span-sharemode").html("OFF");
		}
        showLoading1();
        showStatus1("Loading Google Drive files...");
        getDriveFiles1();
    });
	
	// initiate the add folder button. Click this button will popup a window for
	// user to enter the folder name.
	$("#button-addfolder").click(function () {
        $("#transparent-wrapper1").show();
        $("#float-box1").show();
        $("#txtFolder").val("");
    });
	
	// This button will be used to send a request to add a folder to Google API
	// site
	$("#btnAddFolder").click(function () {
        if ($("#txtFolder").val() == "") {
            alert("Please enter the folder name");
        } else {
            $("#transparent-wrapper1").hide();
            $("#float-box1").hide();
            showLoading1();
            showStatus1("Creating folder in progress...");
			var access_token =  gapi.auth.getToken().access_token;
			var request = gapi.client.request({
			   'path': '/drive/v2/files/',
			   'method': 'POST',
			   'headers': {
				   'Content-Type': 'application/json',
				   'Authorization': 'Bearer ' + access_token,             
			   },
			   'body':{
				   "title" : $("#txtFolder").val(),
				   "mimeType" : "application/vnd.google-apps.folder",
				   "parents": [{
						"kind": "drive#file",
						"id": FOLDER_ID
					}]
			   }
			});
			
			request.execute(function(resp) { 
			   if (!resp.error) {
					showStatus1("Loading Google Drive files...");
					getDriveFiles1();
			   }else{
					hideStatus1();
					hideLoading1();
					showErrorMessage1("Error: " + resp.error.message);
			   }
			});
        }
    });
	
	// Initiate the close button to hide popup box and transparent gradient
	// wrapper
	$(".btnClose1, .imgClose1").click(function () {
        $("#transparent-wrapper1").hide();
        $(".float-box1").hide();
    });
	
	// Initiate button to logout the user by specifying the frame source, this
	// will force the logout.
	$("#link-logout1").click(function () {
        var c = confirm("Are you sure you want to logout from your Google Drive account?");
        if (c) {
            $('#frameLogout1').attr("src","https://accounts.google.com/logout");
            showLoading1();
            setTimeout(function () {
                $("#login-panel").show();
                $("#drive-ouput").hide();
            }, 1000);
        }
    });
});

/** ****************** END PAGE LOAD ******************* */

/** ****************** DRIVER API ******************* */
function getDriveFiles1(){
	showStatus1("Loading Google Drive files...");
    gapi.client.load('drive', 'v2', getFiles1);
}

// This will get the files information
function getFiles1(){
	var query = "";
	if (ifShowSharedFiles1()) {
		$(".button-opt").hide();
		query = (FOLDER_ID == "0B_KzijCYeJPvalRhMFVpYjl2bTA") ? "trashed=false and sharedWithMe" : "trashed=false and '" + FOLDER_ID + "' in parents";
		if (FOLDER_ID != "0B_KzijCYeJPvalRhMFVpYjl2bTA" && FOLDER_PERMISSION == "true") {
			$(".button-opt").show();
		}
	}else{
		$(".button-opt").show();
		query = "trashed=false and '" + FOLDER_ID + "' in parents";
	}
    var request = gapi.client.drive.files.list({
        'maxResults': NO_OF_FILES,
        'q': query
    });

    request.execute(function (resp) {
       if (!resp.error) {
			showUserInfo1();
            DRIVE_FILES = resp.items;           
	            buildFiles1();
	           
	            foldering([{name:'parentFolder', value: FOLDER_ID},{name:'idFolder', value: DRIVE_FILES[0].id},
	                       {name:'typeFolder', value: DRIVE_FILES[0].fileType},{name:'nameFolder', value: DRIVE_FILES[0].title},
	                       {name:'dateFolder', value: DRIVE_FILES[0].createdDate},{name:'levelFolder', value: DRIVE_FILES[0].level}]);
	          
	            
       }else{
            showErrorMessage1("Error: " + resp.error.message);
       }
    });
}

// This will show the user information
function showUserInfo1(){
	var request = gapi.client.drive.about.get();
    var obj = {};
    request.execute(function(resp) { 
       if (!resp.error) {
			$("#drive-info").show();
			$("#span-name").html(resp.name);
			$("#span-totalQuota").html(formatBytes1(resp.quotaBytesTotal));
			$("#span-usedQuota").html(formatBytes1(resp.quotaBytesUsed));
       }else{
            showErrorMessage1("Error: " + resp.error.message);
       }
   });
}

// This will build the user information
function buildFiles1(){
	var fText = "";
    if (DRIVE_FILES.length > 0) {
    	
    	console.log("es yes yes " + DRIVE_FILES[0].id + " ");
    	IDNewFolder = DRIVE_FILES[0].id;
    	
    	for (var i = 0; i < DRIVE_FILES.length; i++) {
			DRIVE_FILES[i].textContentURL = "";
			DRIVE_FILES[i].level = (parseInt(FOLDER_LEVEL) + 1).toString();
			DRIVE_FILES[i].parentID = (DRIVE_FILES[i].parents.length > 0) ? DRIVE_FILES[i].parents[0].id : "";
			DRIVE_FILES[i].thumbnailLink = DRIVE_FILES[i].thumbnailLink || '';
			DRIVE_FILES[i].fileType =  (DRIVE_FILES[i].fileExtension == null) ? "folder" : "file";
			DRIVE_FILES[i].permissionRole = DRIVE_FILES[i].userPermission.role;
			DRIVE_FILES[i].hasPermission = (DRIVE_FILES[i].permissionRole == "owner" || DRIVE_FILES[i].permissionRole == "writer");
			var textContentURL = '';
			if(DRIVE_FILES[i]['exportLinks'] != null){
				DRIVE_FILES[i].fileType = "file";
				DRIVE_FILES[i].textContentURL = DRIVE_FILES[i]['exportLinks']['text/plain'];
			}
			var textTitle = (DRIVE_FILES[i].fileType != "file") ? "Browse " + DRIVE_FILES[i].title : DRIVE_FILES[i].title;

            fText += "<div class='" + DRIVE_FILES[i].fileType + "-box'>";
			if (DRIVE_FILES[i].fileType != "file") {
				fText += "<div class='folder-icon' data-level='" + DRIVE_FILES[i].level + "' data-parent='" + DRIVE_FILES[i].parentID + "' data-size='" + DRIVE_FILES[i].fileSize + "' data-id='" + DRIVE_FILES[i].id + "' title='" + textTitle + "' data-name='" + DRIVE_FILES[i].title + "' data-has-permission='" +DRIVE_FILES[i].hasPermission + "'><div class='image-preview'><img src='https://www.pngwebicons.com/upload/small/folders_PNG8760.png'/></div></div>";
			} else {
				if (DRIVE_FILES[i].thumbnailLink) {
					fText += "<div class='image-icon'><div class='image-preview'><a href='" + DRIVE_FILES[i].thumbnailLink.replace("s220", "s800") + "' data-lightbox='image-" + i + "'><img src='" + DRIVE_FILES[i].thumbnailLink + "'/></a></div></div>";
				}else {
					fText += "<div class='file-icon'><div class='image-preview'><img src='images/" + DRIVE_FILES[i].fileExtension + "-icon.png" + "'/></div></div>";
				}
			}
			fText += "<div class='item-title'>" + DRIVE_FILES[i].title + "</div>";

			// button actions
			fText += "<div class='button-box'>";
				if (DRIVE_FILES[i].fileType != "folder") {
					fText += "<div class='button-download' title='Download' data-id='" + DRIVE_FILES[i].id + "' data-file-counter='" + i + "'></div>";
				}
				
				if (DRIVE_FILES[i].textContentURL.length > 0) {
					fText += "<div class='button-text' title='Get Text' data-id='" + DRIVE_FILES[i].id + "' data-file-counter='" + i + "'></div>";
				}
				
				fText += "<div class='button-info' title='Info' data-id='" + DRIVE_FILES[i].id + "' data-file-counter='" + i + "'></div>";
				
				if (DRIVE_FILES[i].hasPermission) {
					if (DRIVE_FILES[i].permissionRole == "owner") {
						fText += "<div class='button-delete' title='Delete' data-id='" + DRIVE_FILES[i].id + "'></div>";
					}else if(DRIVE_FILES[i].fileType != "folder"){
						fText += "<div class='button-delete' title='Delete' data-id='" + DRIVE_FILES[i].id + "'></div>";
					}
				}
				
			fText += "</div>";
			
			// closing div
			fText += "</div>";
        }
    } else {
        fText = 'No files found.';
    }
    hideStatus1();
    $(".drive-content1").html(fText);
    initDriveButtons1();
    hideLoading1();
}

// Initialize the click button for each individual drive file/folder
// this need to be recalled everytime the Google Drive data is generated
function initDriveButtons1(){
	// Initiate the delete button click
	$(".button-delete").unbind("click");
    $(".button-delete").click(function () {
        var c = confirm("Are you sure you want to delete this?");
        if (c) {
            showLoading1();
            showStatus1("Deleting file in progress...");
			var request = gapi.client.drive.files.delete({
				'fileId': $(this).attr("data-id")
			});

			request.execute(function(resp) { 
			   hideStatus1();
			   if (resp.error) {
					showErrorMessage1("Error: " + resp.error.message);
			   }
			   getDriveFiles1();
			});
        }
    });
	
	// Initiate the download button
	$(".button-download").unbind("click");
    $(".button-download").click(function () {
        showLoading1();
        showStatus1("Downloading file in progress...");
        FILE_COUNTER = $(this).attr("data-file-counter");
        setTimeout(function () {
			// If there is a text version, we get this version instead.
			if(DRIVE_FILES[FILE_COUNTER].webContentLink == null){
				window.open(DRIVE_FILES[FILE_COUNTER]['exportLinks']['text/plain']);
			}else{
				window.open(DRIVE_FILES[FILE_COUNTER].webContentLink);
			}
			hideLoading1();
			hideStatus1();
		}, 1000);
    });
	
	$(".button-info").unbind("click");
    $(".button-info").click(function () {
		FILE_COUNTER = $(this).attr("data-file-counter");
        $("#transparent-wrapper1").show();
        $("#float-box-info").show();
        if (DRIVE_FILES[FILE_COUNTER] != null) {
            var createdDate = new Date(DRIVE_FILES[FILE_COUNTER].createdDate);
            var modifiedDate = new Date(DRIVE_FILES[FILE_COUNTER].modifiedDate);
            $("#spanCreatedDate").html(createdDate.toString("dddd, d MMMM yyyy h:mm:ss tt"));
            $("#spanModifiedDate").html(modifiedDate.toString("dddd, d MMMM yyyy h:mm:ss tt"));
            $("#spanOwner").html((DRIVE_FILES[FILE_COUNTER].owners[0].displayName.length > 0) ? DRIVE_FILES[FILE_COUNTER].owners[0].displayName : "");
            $("#spanTitle").html(DRIVE_FILES[FILE_COUNTER].title);
            $("#spanSize").html((DRIVE_FILES[FILE_COUNTER].fileSize == null) ? "N/A" : formatBytes1(DRIVE_FILES[FILE_COUNTER].fileSize));
            $("#spanExtension").html(DRIVE_FILES[FILE_COUNTER].fileExtension);
        }
    });
	
	// Initiate the get text button
	$(".button-text").unbind("click");
    $(".button-text").click(function () {
		FILE_COUNTER = $(this).attr("data-file-counter");
        showLoading1();
		showStatus1("Getting text file in progress...");
		var accessToken = gapi.auth.getToken().access_token;
		var xhr = new XMLHttpRequest();
		xhr.open('GET', DRIVE_FILES[FILE_COUNTER]['exportLinks']['text/plain']);
		xhr.setRequestHeader('Authorization', 'Bearer ' + accessToken);
		xhr.onload = function() {
			callBackGetText1(xhr.responseText);
		};
		xhr.onerror = function() {
			callBackGetText1(null);
		};
		xhr.send();
    });
	
	// Initiate the click folder browse icon
	$(".folder-icon").unbind("click");
    $(".folder-icon").click(function () {
        browseFolder1($(this));
    });

	// Initiate the breadcrumb navigation link click
    $("#drive-breadcrumb1 a").unbind("click");
    $("#drive-breadcrumb1 a").click(function () {
        browseFolder1($(this));
    });
}


// browse folder
function browseFolder1(obj) {
    FOLDER_ID = $(obj).attr("data-id");
    FOLDER_NAME = $(obj).attr("data-name");
    FOLDER_LEVEL = parseInt($(obj).attr("data-level"));
	FOLDER_PERMISSION = $(obj).attr("data-has-permission");

    if (typeof FOLDER_NAME === "undefined") {
        FOLDER_NAME = "";
        FOLDER_ID = idFOLDER;
        FOLDER_LEVEL = 0;
		FOLDER_PERMISSION = true;
        FOLDER_ARRAY = [];
    } else {
        if (FOLDER_LEVEL == FOLDER_ARRAY.length && FOLDER_LEVEL > 0) {
            // do nothing
        } else if (FOLDER_LEVEL < FOLDER_ARRAY.length) {
            var tmpArray = cloneObject1(FOLDER_ARRAY);
            FOLDER_ARRAY = [];

            for (var i = 0; i < tmpArray.length; i++) {
                FOLDER_ARRAY.push(tmpArray[i]);
                if (tmpArray[i].Level >= FOLDER_LEVEL) { break; }
            }
        } else {
            var fd = {
                Name: FOLDER_NAME,
                ID: FOLDER_ID,
                Level: FOLDER_LEVEL,
				Permission: FOLDER_PERMISSION
            }
            FOLDER_ARRAY.push(fd);
        }
    }

    var sbNav = "";
    for (var i = 0; i < FOLDER_ARRAY.length; i++) {
        sbNav +="<span class='breadcrumb-arrow1'></span>";
        sbNav +="<span class='folder-name'><a data-id='" + FOLDER_ARRAY[i].ID + "' data-level='" + FOLDER_ARRAY[i].Level + "' data-name='" + FOLDER_ARRAY[i].Name + "' data-has-permission='" + FOLDER_PERMISSION + "'>" + FOLDER_ARRAY[i].Name + "</a></span>";
    }
    $("#span-navigation1").html(sbNav.toString());

    showLoading1();
    showStatus1("Loading Google Drive files...");
    getDriveFiles1();
}

// call back function for getting text
function callBackGetText1(response){
    if(response == null){
         showErrorMessage1("Error getting text content.");
    }else{
        hideLoading1();
        hideStatus1();
        $("#transparent-wrapper1").show();
        $("#float-box-text1").show();
        $("#text-content1").html(response.replace(/(\r\n|\n|\r)/gm, "<br>"));
    }
}

// function to clone an object
function cloneObject1(obj) {
    if (obj === null || typeof obj !== 'object') {
        return obj;
    }
    var temp = obj.constructor(); 
    for (var key in obj) {
        temp[key] = cloneObject1(obj[key]);
    }
    return temp;
}

// show whether the display mode is share files or not
function ifShowSharedFiles1() {
    return ($("#button-share.flash").length > 0) ? true : false;
}

// function to return bytes into different string data format
function formatBytes1(bytes) {
    if (bytes < 1024) return bytes + " Bytes";
    else if (bytes < 1048576) return (bytes / 1024).toFixed(3) + " KB";
    else if (bytes < 1073741824) return (bytes / 1048576).toFixed(3) + " MB";
    else return (bytes / 1073741824).toFixed(3) + " GB";
};

/** ****************** END DRIVER API ******************* */



/** ****************** NOTIFICATION ******************* */
// show loading animation
function showLoading1() {
    if ($("#drive-box1-loading").length === 0) {
        $("#drive-box1").prepend("<div id='drive-box1-loading'></div>");
    }
    $("#drive-box1-loading").html("<div id='loading-wrapper'><div id='loading'></div></div>");
}

// hide loading animation
function hideLoading1() {
    $("#drive-box1-loading").html("");
}

// show status message
function showStatus1(text) {
    $("#status-message").show();
    $("#status-message").html(text);
}

// hide status message
function hideStatus1() {
    $("#status-message").hide();
    $("#status-message").html("");
}

// show upload progress
function showProgressPercentage1(percentageValue) {
    if ($("#upload-percentage").length == 0) {
        $("#drive-box1").prepend("<div id='upload-percentage' class='flash1'></div>");
    }
    if (!$("#upload-percentage").is(":visible")) {
        $("#upload-percentage").show(1000);
    }
    $("#upload-percentage").html(percentageValue.toString() + "%");
}

// show error message
function showErrorMessage1(errorMessage) {
    $("#error-message1").html(errorMessage);
    $("#error-message1").show(100);
    setTimeout(function () {
        $("#error-message1").hide(100);
    }, 3000);
}

/** ****************** END NOTIFICATION ******************* */

// Create folder
function createFolder1() {
		var titre = document.getElementById("hformid:nomProjet").value;
        $("#transparent-wrapper1").hide();
        $("#float-box1").hide();
        showLoading1();
        showStatus1("Creating folder in progress...");
		var access_token =  gapi.auth.getToken().access_token;
		var request = gapi.client.request({
		   'path': '/drive/v2/files/',
		   'method': 'POST',
		   'headers': {
			   'Content-Type': 'application/json',
			   'Authorization': 'Bearer ' + access_token,             
		   },
		   'body':{
			   "title" : titre ,
			   "mimeType" : "application/vnd.google-apps.folder",
			   "parents": [{
					"kind": "drive#file",
					"id": FOLDER_ID
				}]
		   }
		});
		
		request.execute(function(resp) { 
		   if (!resp.error) {
				showStatus1("Loading Google Drive files...");
				getDriveFiles1();	
		    	IDNewFolder = DRIVE_FILES[0].id;
				
		   }else{
				hideStatus1();
				hideLoading1();
				showErrorMessage1("Error: " + resp.error.message);
		   }
		});
}

//Get ID Folder
function getIDFolder(){
}
