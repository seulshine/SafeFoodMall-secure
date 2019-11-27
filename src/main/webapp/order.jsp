<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">
<title>상세정보</title>
<!-- bootstrap 3.3.7이하는 jQuery 1.x, 3.3.7이상으로 업그레이드 필요 -->
<!-- Insert in <head> -->
<link href="./js/calendarorganizer.min.css" rel="stylesheet" />
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

<!-- 부가적인 테마 -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css">

<!-- jQuery 추가 -->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

<!-- 합쳐지고 최소화된 최신 자바스크립트 -->
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<!-- Insert before you own <script> tag-->
<script src="./js/calendarorganizer.min.js"></script>


<style>
@import url(https://fonts.googleapis.com/css?family=Open+Sans:400,700);

.container {
	margin-bottom: 10px;
}

#navbar {
	padding-right: 20px;
}

footer {
	background: #f0f0f0;
	padding: 5px 15px 10px 15px;
}

#nut {
	margin-top: 50px;
}

#info th {
	text-align: center;
	width: 80px;
}

#nutr th {
	text-align: center;
	width: 100px;
}

#table {
	align-items: center;
	margin-left: 380px;
}

#calendar {
	margin-left:15%;
	margin-top: 100px;
	width: 1500px;
	height:500px;
}
</style>
</head>
<script type="text/javascript"
	src="https://www.gstatic.com/charts/loader.js"></script>
<body>
	<jsp:include page="/top.jsp" />
	<div id="calendar">
	    <div class="col-md-4 col-md-offset-2" id="calendarContainer"></div>
	    <div class="col-md-4" id="organizerContainer"></div>
	</div>
	<div style='text-align: center;'>
		먹은음식
		<input type='text' id='foodName'>
	</div>
	<div style='text-align: center;'>
		먹은끼니
		<input type='text' id='mealTime'>
	</div>
	<div style='text-align: center;'>
		먹은시간
		<input type='text' id='eatenTime'>
	</div>
	<div style='text-align: center;'>
		<button onclick="addDiary()">저장</button>
	</div>
	<jsp:include page="/bottom.jsp" />

</body>
 <script src="https://cdn.rawgit.com/nizarmah/calendar-javascript-lib/master/calendarorganizer.min.js"></script>
<script>

var calendar = new Calendar("calendarContainer",         // HTML container ID,                                                                     Required
        "small",                     // Size: (small, medium, large)                                                           Required
        ["Sunday", 3],               // [ Starting day, day abbreviation length ]                                              Required
        [ "#ffc107",                 // Primary Color                                                                          Required
          "#ffa000",                 // Primary Dark Color                                                                     Required
          "#ffffff",                 // Text Color                                                                             Required
          "#ffecb3" ],               // Text Dark Color                                                                        Required
        { // Following is optional
            days: [ "Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday",  "Saturday" ],
            months: [ "January", "Feburary", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December" ],
            indicator: true,         // Day Event Indicator                                                                    Optional
            indicator_type: 1,       // Day Event Indicator Type (0 not to display num of events, 1 to display num of events)  Optional
            indicator_pos: "bottom", // Day Event Indicator Position (top, bottom)                                             Optional
        });
        
        
var data = {
            2019: {
                11: {
                    26: [
                        {
                            startTime: "점심",
                            endTime: "14:00",
                            text: "Christmas Day"
                        },
                    ]
                }
            }
        };

var organizer = new Organizer("organizerContainer", calendar, data);


//Days Block click listener
calendar.setOnClickListener('days-blocks',
    // Called when a day block is clicked
    function () {
        console.log("Day block clicked");
    }
);

// Month Slider (Left and Right Arrow) Click Listeners
calendar.setOnClickListener('month-slider',
    // Called when the month left arrow is clicked
    function () {
        console.log("Month back slider clicked");
    },
    // Called when the month right arrow is clicked
    function () {
        console.log("Month next slider clicked");
    }
);

// Year Slider (Left and Right Arrow) Click Listeners
calendar.setOnClickListener('year-slider',
    // Called when the year left arrow is clicked
    function () {
        console.log("Year back slider clicked");
    },
    // Called when the year right arrow is clicked
    function () {
        console.log("Year next slider clicked");
    }
);


//Days Block Click Listener
organizer.setOnClickListener('days-blocks',
    // Called when a day block is clicked
    function () {
        console.log("Day block clicked");
    }
);

// Days Block Long Click Listener
organizer.setOnLongClickListener('days-blocks',
    // Called when a day block is long clicked
    function () {
        console.log("Day block long clicked");
    }
);

// Month Slider (Left and Right Arrow) Click Listeners
organizer.setOnClickListener('month-slider',
    // Called when the month left arrow is clicked
    function () {
        console.log("Month back slider clicked");
    },
    // Called when the month right arrow is clicked
    function () {
        console.log("Month next slider clicked");
    }
);

// Year Slider (Left and Right Arrow) Click Listeners
organizer.setOnClickListener('year-slider',
    // Called when the year left arrow is clicked
    function () {
        console.log("Year back slider clicked");
    },
    // Called when the year right arrow is clicked
    function () {
        console.log("Year next slider clicked");
    }
);


organizer.onMonthChange = function (callback) {
	let dateStr = calendar.getDateString().split(' ');
	let mon = 0;
	if(dateStr[0] == 'January') {
		mon = 1;
	} else if(dateStr[0] == 'Feburary'){
		mon = 2;
	} else if(dateStr[0] == 'March'){
		mon = 3;
	} else if(dateStr[0] == 'April'){
		mon = 4;
	} else if(dateStr[0] == 'May'){
		mon = 5;
	} else if(dateStr[0] == 'June'){
		mon = 6;
	} else if(dateStr[0] == 'July'){
		mon = 7;
	} else if(dateStr[0] == 'August'){
		mon = 8;
	} else if(dateStr[0] == 'September'){
		mon = 9;
	} else if(dateStr[0] == 'October'){
		mon = 10;
	} else if(dateStr[0] == 'November'){
		mon = 11;
	} else if(dateStr[0] == 'December'){
		mon = 12;
	}
	let day = dateStr[1].substr(0, dateStr[1].length-1);
	let year = dateStr[2];
	
	let list = [];
	$.ajax({
		url : "/safefoodvue/diary/searchDiary",
		type : 'post',
		headers: { 
	        'Accept': 'application/json',
	        'Content-Type': 'application/json' 
	    },
		data : JSON.stringify({
			year: year,
			month: mon,
		}),
		success : function(response) {
			//data = {};
			response.forEach(resData => {
				if(data.hasOwnProperty(resData.year)){
					if(data[resData.year].hasOwnProperty(resData.month)){
						if(data[resData.year][resData.month].hasOwnProperty(resData.day)){
							data[resData.year][resData.month][resData.day].push({
								startTime: resData.meal,
								endTime: resData.time,
								text: resData.kind
							})
						} else {
							data[resData.year][resData.month][resData.day] = [{
								startTime: resData.meal,
								endTime: resData.time,
								text: resData.kind
							}]
						}
					} else {
						data[resData.year][resData.month] = {};
						data[resData.year][resData.month][resData.day] = [{
							startTime: resData.meal,
							endTime: resData.time,
							text: resData.kind
						}]
					}
				} else {
					data[resData.year] = {};
					data[resData.year][resData.month] = {};
					data[resData.year][resData.month][resData.day] = [{
						startTime: resData.meal,
						endTime: resData.time,
						text: resData.kind
					}]
				}

			});
			calendar.update();
			//console.log(response);
		},
		error : function() {
			alert("error");
		}
	});
	
		
};

addDiary = function(){
	let dateStr = calendar.getDateString().split(' ');
	let mon = 0;
	if(dateStr[0] == 'January') {
		mon = 1;
	} else if(dateStr[0] == 'Feburary'){
		mon = 2;
	} else if(dateStr[0] == 'March'){
		mon = 3;
	} else if(dateStr[0] == 'April'){
		mon = 4;
	} else if(dateStr[0] == 'May'){
		mon = 5;
	} else if(dateStr[0] == 'June'){
		mon = 6;
	} else if(dateStr[0] == 'July'){
		mon = 7;
	} else if(dateStr[0] == 'August'){
		mon = 8;
	} else if(dateStr[0] == 'September'){
		mon = 9;
	} else if(dateStr[0] == 'October'){
		mon = 10;
	} else if(dateStr[0] == 'November'){
		mon = 11;
	} else if(dateStr[0] == 'December'){
		mon = 12;
	}
	let day = dateStr[1].substr(0, dateStr[1].length-1);
	let year = dateStr[2];
	

	console.log(mon, day, year);

	let foodName = $("#foodName").val();
	let mealTime = $("#mealTime").val();
	let eatenTime = $("#eatenTime").val();
	
	//year, month, day, meal, time, kind
	$.ajax({
		url : "/safefoodvue/diary/insertDiary",
		type : 'post',
		headers: { 
	        'Accept': 'application/json',
	        'Content-Type': 'application/json' 
	    },
		data : JSON.stringify({
			year: year,
			month: mon,
			day: day,
			meal: mealTime,
			time: eatenTime,
			kind: foodName
		}),
		success : function(response) {
			//data = response;
			console.log(response);
			
		},
		error : function() {
			alert("error");
		}
	});
	
	if(data.hasOwnProperty(year)){
		if(data[year].hasOwnProperty(mon)){
			if(data[year][mon].hasOwnProperty(day)){
				data[year][mon][day].push({
					startTime: mealTime,
					endTime: eatenTime,
					text: foodName
				})
			} else {
				data[year][mon][day] = [{
					startTime: mealTime,
					endTime: eatenTime,
					text: foodName
				}]
			}
		} else {
			data[year][mon] = {};
			data[year][mon][day] = [{
				startTime: mealTime,
				endTime: eatenTime,
				text: foodName
			}]
		}
	} else {
		data[year] = {};
		data[year][mon] = {};
		data[year][mon][day] = [{
			startTime: mealTime,
			endTime: eatenTime,
			text: foodName
		}]
	}
	calendar.update();
	
	$("#foodName").val('');
	$("#mealTime").val('');
	$("#eatenTime").val('');
}


</script>
</html>