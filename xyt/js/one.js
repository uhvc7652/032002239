var dice = 0;
var diceforscore = 0;
var leftchess = [0,0,0,0,0,0,0,0,0];
var rightchess = [0,0,0,0,0,0,0,0,0];
var isleft=1;
var isright=0;
var leftcount=0;
var rightcount=0;
var leftscore=0;
var rightscore=0;
var diceimg = ["img/6.jpg","images/1.jpg","images/2.jpg","images/3.jpg","images/4.jpg","images/5.jpg","images/6.jpg"];
function throwt() {
	if (dice==0){
        	var num = 0;
        	var tempdice;
        	var interval = setInterval(function() {
            	num += 1;
            	tempdice = Math.floor((Math.random() * 10) + 1) % 6 + 1;
            	switch (tempdice) {
                	case 1:
                    	$("#dice_img").attr("src", diceimg[1]);
                    	break;
                	case 2:
                    	$("#dice_img").attr("src", diceimg[2]);
                    	break;
                	case 3:
                    	$("#dice_img").attr("src", diceimg[3]);
                    	break;
                	case 4:
                    	$("#dice_img").attr("src", diceimg[4]);
                    	break;
                	case 5:
                    	$("#dice_img").attr("src", diceimg[5]);
                    	break;
                	case 6:
                    	$("#dice_img").attr("src", diceimg[6]);
                    	break;
                	default:
                    	break;
            	}
            	if (num == 20) {
                	clearInterval(interval);
                	var texts = "摇骰子，您的结果是：" + tempdice;
                	dice=tempdice;
                	diceforscore=dice;
                	$("span.text").text(texts);
            	}
        	}, 50);
    	}//掷骰子
    }
function lay(num){
		if (isleft==1&&dice!=0){
			switch (num) {
                case 1:
                	if (leftchess[0]!=0){
						break;
					}
                    leftchess[0]=dice;
            		isleft=0;
            		isright=1;
            		dice=0;
					updatescore(num);
                    break;
                case 2:
                	if (leftchess[1]!=0){
						break;
					}
                    leftchess[1]=dice;
            		isleft=0;
            		isright=1;
            		dice=0;
					updatescore(num);
                    break;
                case 3:
                	if (leftchess[2]!=0){
						break;
					}
                    leftchess[2]=dice;
            		isleft=0;
            		isright=1;
            		dice=0;
					updatescore(num);
                    break;
                case 4:
                	if (leftchess[3]!=0){
						break;
					}
                    leftchess[3]=dice;
            		isleft=0;
            		isright=1;
            		dice=0;
					updatescore(num);
                    break;
                case 5:
                	if (leftchess[4]!=0){
						break;
					}
                    leftchess[4]=dice;
            		isleft=0;
            		isright=1;
            		dice=0;
					updatescore(num);
                    break;
                case 6:
                	if (leftchess[5]!=0){
						break;
					}
                    leftchess[5]=dice;
            		isleft=0;
            		isright=1;
            		dice=0;
					updatescore(num);
                    break;
                case 7:
                	if (leftchess[6]!=0){
						break;
					}
                    leftchess[6]=dice;
            		isleft=0;
            		isright=1;
            		dice=0;
					updatescore(num);
                    break;
                case 8:
                	if (leftchess[7]!=0){
						break;
					}
                    leftchess[7]=dice;
            		isleft=0;
            		isright=1;
            		dice=0;
					updatescore(num);
                    break;
                case 9:
                	if (leftchess[8]!=0){
						break;
					}
                    leftchess[8]=dice;
            		isleft=0;
            		isright=1;
            		dice=0;
					updatescore(num);
                    break;
                default:
                    break;
            }
		}
		else if (isright==1&&dice!=0){
			switch (num) {
                case 10:
                	if (rightchess[0]!=0){
						break;
					}
                    rightchess[0]=dice;
            		isright=0;
            		isleft=1;
            		dice=0;
					updatescore(num);
                    break;
                case 11:
                	if (rightchess[1]!=0){
						break;
					}
                    rightchess[1]=dice;
            		isright=0;
            		isleft=1;
            		dice=0;
					updatescore(num);
                    break;
                case 12:
                	if (rightchess[2]!=0){
						break;
					}
                    rightchess[2]=dice;
            		isright=0;
            		isleft=1;
            		dice=0;
					updatescore(num);
                    break;
                case 13:
                	if (rightchess[3]!=0){
						break;
					}
                    rightchess[3]=dice;
            		isright=0;
            		isleft=1;
            		dice=0;
					updatescore(num);
                    break;
                case 14:
                	if (rightchess[4]!=0){
						break;
					}
                    rightchess[4]=dice;
            		isright=0;
            		isleft=1;
            		dice=0;
					updatescore(num);
                    break;
                case 15:
                	if (rightchess[5]!=0){
						break;
					}
                    rightchess[5]=dice;
            		isright=0;
            		isleft=1;
            		dice=0;
					updatescore(num);
                    break;
                case 16:
                	if (rightchess[6]!=0){
						break;
					}
                    rightchess[6]=dice;
            		isright=0;
            		isleft=1;
            		dice=0;
					updatescore(num);
                    break;
                case 17:
                	if (rightchess[7]!=0){
						break;
					}
                    rightchess[7]=dice;
            		isright=0;
            		isleft=1;
            		dice=0;
					updatescore(num);
                    break;
                case 18:
                	if (rightchess[8]!=0){
						break;
					}
                    rightchess[8]=dice;
            		isright=0;
            		isleft=1;
            		dice=0;
					updatescore(num);
                    break;
                default:
                    break;
            }
		}
		else ;
}
function updatescore(num){
	addborder();
	var l=0;
	var r=0;
	var l1 = [0,0,0,0,0,0];
	var r1 = [0,0,0,0,0,0];
	var l2 = [0,0,0,0,0,0];
	var r2 = [0,0,0,0,0,0];
	var l3 = [0,0,0,0,0,0];
	var r3 = [0,0,0,0,0,0];
	for(var i=0;i<3;i++){
		if (leftchess[i]!=0){
			l1[leftchess[i]-1]++;
		}
		if (rightchess[i]!=0){
			r1[rightchess[i]-1]++;
		}
	}
	for(var i=3;i<6;i++){
		if (leftchess[i]!=0){
			l2[leftchess[i]-1]++;
		}
		if (rightchess[i]!=0){
			r2[rightchess[i]-1]++;
		}
	}
	for(var i=6;i<9;i++){
		if (leftchess[i]!=0){
			l3[leftchess[i]-1]++;
		}
		if (rightchess[i]!=0){
			r3[rightchess[i]-1]++;
		}
	}
	switch(Math.floor((num-1)/3)+1){//棋盘更新
		case 1:
			r1[diceforscore-1]=0;
			for(var i=0;i<3;i++){
				if (rightchess[i]==diceforscore){
					rightchess[i]=0;
				}
			}
			break;
		case 2:
			r2[diceforscore-1]=0;
			for(var i=3;i<6;i++){
				if (rightchess[i]==diceforscore){
					rightchess[i]=0;
				}
			}
			break;
		case 3:
			r3[diceforscore-1]=0;
			for(var i=6;i<9;i++){
				if (rightchess[i]==diceforscore){
					rightchess[i]=0;
				}
			}
			break;
		case 4:
			l1[diceforscore-1]=0;
			for(var i=0;i<3;i++){
				if (leftchess[i]==diceforscore){
					leftchess[i]=0;
				}
			}
			break;
		case 5:
			l2[diceforscore-1]=0;
			for(var i=3;i<6;i++){
				if (leftchess[i]==diceforscore){
					leftchess[i]=0;
				}
			}
			break;
		case 6:
			l3[diceforscore-1]=0;
			for(var i=6;i<9;i++){
				if (leftchess[i]==diceforscore){
					leftchess[i]=0;
				}
			}
			break;
		default:
			break;
	}
	leftcount=0;
	rightcount=0;
	for(var i=0;i<6;i++){
		leftcount+=l1[i];
		rightcount+=r1[i];
		l+=l1[i]*l1[i]*(i+1);
		r+=r1[i]*r1[i]*(i+1);
	}
	for(var i=0;i<6;i++){
		leftcount+=l2[i];
		rightcount+=r2[i];
		l+=l2[i]*l2[i]*(i+1);
		r+=r2[i]*r2[i]*(i+1);
	}
	for(var i=0;i<6;i++){
		leftcount+=l3[i];
		rightcount+=r3[i];
		l+=l3[i]*l3[i]*(i+1);
		r+=r3[i]*r3[i]*(i+1);
	}
	leftscore=l;
	rightscore=r;
	document.getElementById("left").innerHTML=leftscore;
	document.getElementById("right").innerHTML=rightscore;
	refresh();
	isover();
}
function refresh(){
	$("#cl1").attr("src", diceimg[leftchess[0]]);
	$("#cl2").attr("src", diceimg[leftchess[1]]);
	$("#cl3").attr("src", diceimg[leftchess[2]]);
	$("#cl4").attr("src", diceimg[leftchess[3]]);
	$("#cl5").attr("src", diceimg[leftchess[4]]);
	$("#cl6").attr("src", diceimg[leftchess[5]]);
	$("#cl7").attr("src", diceimg[leftchess[6]]);
	$("#cl8").attr("src", diceimg[leftchess[7]]);
	$("#cl9").attr("src", diceimg[leftchess[8]]);
	$("#cr1").attr("src", diceimg[rightchess[0]]);
	$("#cr2").attr("src", diceimg[rightchess[1]]);
	$("#cr3").attr("src", diceimg[rightchess[2]]);
	$("#cr4").attr("src", diceimg[rightchess[3]]);
	$("#cr5").attr("src", diceimg[rightchess[4]]);
	$("#cr6").attr("src", diceimg[rightchess[5]]);
	$("#cr7").attr("src", diceimg[rightchess[6]]);
	$("#cr8").attr("src", diceimg[rightchess[7]]);
	$("#cr9").attr("src", diceimg[rightchess[8]]);
}
function isover(){
	if (leftcount==9||rightcount==9){
		if (leftscore>rightscore){
			alert("左方胜");
			location.reload();
		}
		else if (leftscore==rightscore){
			alert("平局");
			location.reload();
		}
		else{
			alert("右方胜");
			location.reload();
		}
	}
}
function addborder(){
	if (isleft==1){
		document.getElementById("box1").style.border="5px solid red";
		document.getElementById("box2").style.border="5px solid white";
	}
	else {
		document.getElementById("box1").style.border="5px solid white";
		document.getElementById("box2").style.border="5px solid red";
	}
}
 