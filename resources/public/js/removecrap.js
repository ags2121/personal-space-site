(function myLoop (i) {
	setTimeout(function () {
		var childNodes = document.querySelector('body').childNodes;
		for (var x in childNodes) {
			if (childNodes[x].tagName == 'DIV' && childNodes[x].id != 'app') {
				childNodes[x].remove()
			}
		}
		if (--i) myLoop(i);      //  decrement i and call myLoop again if i > 0
	}, 3000)
})(10);