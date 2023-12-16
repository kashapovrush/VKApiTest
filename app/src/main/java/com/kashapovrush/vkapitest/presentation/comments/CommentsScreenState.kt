package com.kashapovrush.vkapitest.presentation.comments

import com.kashapovrush.vkapitest.domain.FeedPost
import com.kashapovrush.vkapitest.domain.PostComment

sealed class CommentsScreenState {

    object Initial : CommentsScreenState()

    data class Comments(
        val feedPost: FeedPost,
        val comments: List<PostComment>
    ) : CommentsScreenState()
}
