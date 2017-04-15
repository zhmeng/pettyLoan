

var selects = document.getElementsByTagName('select');

var isIE = (document.all && window.ActiveXObject && !window.opera) ? true : false;

function $J(id) {
	return document.getElementById(id);
}

function stopBubbling (ev) {	
	ev.stopPropagation();
}

function rSelects() {
	for (i=0;i<selects.length;i++){
		selects[i].style.display = 'none';
		select_tag = document.createElement('div');
			select_tag.id = 'select_' + selects[i].name;
			select_tag.className = 'select_box';
		selects[i].parentNode.insertBefore(select_tag,selects[i]);

		select_info = document.createElement('div');	
			select_info.id = 'select_info_' + selects[i].name;
			var clname = selects[i].className;
			if(clname != null){
				select_info.className='tag_select';
				select_tag.className = 'select_box ' + clname;
			}else{
				select_info.className='tag_select';
			}
			select_info.style.cursor='pointer';
		select_tag.appendChild(select_info);
		select_icon = document.createElement('div');	
			select_icon.className='select_icon';
		select_info.appendChild(select_icon);
		select_content = document.createElement('div');	
			select_content.className='select_content';
			select_content.id='select_content_' + selects[i].name;
		select_info.appendChild(select_content);
		select_info_width=select_info.offsetWidth-2;

		select_ul = document.createElement('ul');	
			select_ul.id = 'options_' + selects[i].name;
			select_ul.className = 'tag_options';
			select_ul.style.position='absolute';
			select_ul.style.display='none';
			select_ul.style.zIndex='999';
			select_ul.style.width=select_info_width+"px";
		select_tag.appendChild(select_ul);

		rOptions(i,selects[i].name);
		
		mouseSelects(selects[i].name);

		if (isIE){
			selects[i].onclick = new Function("clickLabels3('"+selects[i].name+"');window.event.cancelBubble = true;");
		}
		else if(!isIE){
			selects[i].onclick = new Function("clickLabels3('"+selects[i].name+"')");
			selects[i].addEventListener("click", stopBubbling, false);
		}		
	}
}


function rOptions(i, name) {
	var options = selects[i].getElementsByTagName('option');
	var options_ul = 'options_' + name;
	for (n=0;n<selects[i].options.length;n++){	
		option_li = document.createElement('li');
			option_li.style.cursor='pointer';
			option_li.className='open';
		$J(options_ul).appendChild(option_li);

		option_text = document.createTextNode(selects[i].options[n].text);
		option_li.appendChild(option_text);

		option_selected = selects[i].options[n].selected;

		if(option_selected){
			option_li.className='open_selected';
			option_li.id='selected_' + name;
			$J('select_content_' + name).appendChild(document.createTextNode(option_li.innerHTML));
		}
		
		option_li.onmouseover = function(){	
			this.className='open_hover';
			if($J('selected_' + name)!= null){
			 $J('selected_' + name).className='open';
			 $J('selected_' + name).id='';
			}
		}
		option_li.onmouseout = function(){
			this.className='open';
		} 
	
		option_li.onclick = new Function("clickOptions("+i+","+n+",'"+selects[i].name+"')");
	}
}

function mouseSelects(name){
	var sincn = 'select_info_' + name;

	$J(sincn).onmouseover = function(){ if(this.className=='tag_select') this.className='tag_select_hover'; }
	$J(sincn).onmouseout = function(){ if(this.className=='tag_select_hover') this.className='tag_select'; }

	if (isIE){
		$J(sincn).onclick = new Function("clickSelects('"+name+"');window.event.cancelBubble = true;");
	}
	else if(!isIE){
		$J(sincn).onclick = new Function("clickSelects('"+name+"');");
		$J('select_info_' +name).addEventListener("click", stopBubbling, false);
	}

}

function clickSelects(name){
	var sincn = 'select_info_' + name;
	var sinul = 'options_' + name;	
	
	for (i=0;i<selects.length;i++){	
		if(selects[i].name == name){				
			if( $J(sincn).className =='tag_select_hover'){
				$J(sincn).className ='tag_select_open';
				$J(sinul).style.display = '';
			}
			else if( $J(sincn).className =='tag_select_open'){
				$J(sincn).className = 'tag_select_hover';
				$J(sinul).style.display = 'none';
			}
		}
		else{
			$J('select_info_' + selects[i].name).className = 'tag_select';
			$J('options_' + selects[i].name).style.display = 'none';
		}
	}

}

function clickOptions(i, n, name){		
	var li = $J('options_' + name).getElementsByTagName('li');

	/*$J('selected_' + name).className='open';
	$J('selected_' + name).id='';*/
	li[n].id='selected_' + name;
	li[n].className='open_hover';
	$J('select_' + name).removeChild($J('select_info_' + name));

	select_info = document.createElement('div');
		select_info.id = 'select_info_' + name;
		select_info.className='tag_select';
		select_info.style.cursor='pointer';
	$J('options_' + name).parentNode.insertBefore(select_info,$J('options_' + name));

	mouseSelects(name);

	var select_icon = document.createElement('div');	
	select_icon.className='select_icon';
	$J('select_info_' + name).appendChild(select_icon);
	var select_content = document.createElement('div');	
	select_content.className='select_content';
	select_content.id='select_content_' + selects[i].name;
	$J('select_info_' + name).appendChild(select_content);
	
	$J('select_content_' + name).appendChild(document.createTextNode(li[n].innerHTML));
	$J( 'options_' + name ).style.display = 'none' ;
	$J( 'select_info_' + name ).className = 'tag_select';
	selects[i].options[n].selected = 'selected';
	

}

window.onload = function(e) {
	bodyclick = document.getElementsByTagName('body').item(0);
	rSelects();
	bodyclick.onclick = function(){
		for (i=0;i<selects.length;i++){	
			$J('select_info_' + selects[i].name).className = 'tag_select';
			$J('options_' + selects[i].name).style.display = 'none';
		}
	}
}
