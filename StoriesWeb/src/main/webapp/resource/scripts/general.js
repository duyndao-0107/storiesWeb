/**
 * 
 */

/*$(document).ready(function () {
	var detailItemTab = document.getElementsByClassName('detail_header_item');
	var storyForm = document.getElementsByClassName('storyForm');
	var storyPart = document.getElementsByClassName('storyPart');
	detailItemTab[0].onclick = function() {
	   detailItemTab[0].classList.add("active_detail_header");
	   detailItemTab[1].classList.remove("active_detail_header");
	   storyPart[0]?.classList?.add("non-display");
	   storyPart[0]?.classList?.remove("display");
	   storyForm[0]?.classList?.add("display");
	   storyForm[0]?.classList?.remove("non-display");
	};
	detailItemTab[1].onclick = function() {
	   detailItemTab[0].classList.remove("active_detail_header");
	   detailItemTab[1].classList.add("active_detail_header");
	   storyForm[0]?.classList?.add("non-display");
	   storyForm[0]?.classList?.remove("display");
	   storyPart[0]?.classList?.add("display");
	   storyPart[0]?.classList?.remove("non-display");
	};
});*/


function readURL(input) {
	if (input.files && input.files[0]) {
		var reader = new FileReader();

		reader.onload = function(e) {
			$('#blah')
				.attr('src', e.target.result)
				.width(150)
				.height(200);
		};
		reader.readAsDataURL(input.files[0]);
	}
};
