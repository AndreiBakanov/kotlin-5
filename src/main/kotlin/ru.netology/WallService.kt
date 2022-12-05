package ru.netology

object WallService {
    private var posts = emptyArray<Post>()
    private var comments = emptyArray<Comment>()
    private val newID = posts.size + 1
    private var commentReports = emptyArray<Reports>()
    fun createReport(report: Reports): Int {
        if (report.reason > 8 || report.reason < 0) {
            return throw CorrectReasonNotFoundException("Reason is not correct")
        } else {
            for (comment in comments) {
                if (comment.id == report.commentID) {
                    commentReports += report
                    return 1
                }
            }
            return throw IdNotFoundException("No comment with ${report.commentID}")
        }
    }

    fun createComment(postID: Int, comment: Comment): Comment {
        for (post in posts) {
            if (postID == post.id) {
                comments += comment
                return comment
            }
        }
        return throw PostNotFoundException("No post with $postID")
    }

    fun add(post: Post): Post {
        val post1 = post.copy(id = newID)
        posts += post1
        return posts.last()
    }

    fun update(post: Post): Boolean {
        for ((index, originalPost) in posts.withIndex()) {
            if (post.id == originalPost.id) {
                val newPost = post.copy(id = originalPost.id, date = originalPost.date, ownerID = originalPost.ownerID)
                posts[index] = newPost
                return true
            }
        }
        return false
    }

}