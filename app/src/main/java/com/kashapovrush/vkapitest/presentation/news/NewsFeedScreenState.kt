package com.kashapovrush.vkapitest.presentation.news

import com.kashapovrush.vkapitest.domain.FeedPost

sealed class NewsFeedScreenState {

    object Initial : NewsFeedScreenState()

    data class Posts(val posts: List<FeedPost>) : NewsFeedScreenState()
}
