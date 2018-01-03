/**
 * 
 */
// 댓글 목록 요청 함수
function replylist(boardNo){
	// 댓글 목록
	.ajax({
		type:"get",
		url:"${path}/reply/list?boardNo="+${board.boardNo},
		// 성공적으로 요청 되었을때 반환할 callback 함수
		success:function(result){
			${".result"}.html(result);
		}
	})
}
