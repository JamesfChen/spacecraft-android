package com.hawksjamesf.network.json


import com.alibaba.fastjson.annotation.JSONField

data class GithubApiForFastjson(
    @JSONField(name = "current_user_url")
    val currentUserUrl: String,
    @JSONField(name = "current_user_authorizations_html_url")
    val currentUserAuthorizationsHtmlUrl: String,
    @JSONField(name = "authorizations_url")
    val authorizationsUrl: String,
    @JSONField(name = "code_search_url")
    val codeSearchUrl: String,
    @JSONField(name = "commit_search_url")
    val commitSearchUrl: String,
    @JSONField(name = "emails_url")
    val emailsUrl: String,
    @JSONField(name = "emojis_url")
    val emojisUrl: String,
    @JSONField(name = "events_url")
    val eventsUrl: String,
    @JSONField(name = "feeds_url")
    val feedsUrl: String,
    @JSONField(name = "followers_url")
    val followersUrl: String,
    @JSONField(name = "following_url")
    val followingUrl: String,
    @JSONField(name = "gists_url")
    val gistsUrl: String,
    @JSONField(name = "hub_url")
    val hubUrl: String,
    @JSONField(name = "issue_search_url")
    val issueSearchUrl: String,
    @JSONField(name = "issues_url")
    val issuesUrl: String,
    @JSONField(name = "keys_url")
    val keysUrl: String,
    @JSONField(name = "notifications_url")
    val notificationsUrl: String,
    @JSONField(name = "organization_repositories_url")
    val organizationRepositoriesUrl: String,
    @JSONField(name = "organization_url")
    val organizationUrl: String,
    @JSONField(name = "public_gists_url")
    val publicGistsUrl: String,
    @JSONField(name = "rate_limit_url")
    val rateLimitUrl: String,
    @JSONField(name = "repository_url")
    val repositoryUrl: String,
    @JSONField(name = "repository_search_url")
    val repositorySearchUrl: String,
    @JSONField(name = "current_user_repositories_url")
    val currentUserRepositoriesUrl: String,
    @JSONField(name = "starred_url")
    val starredUrl: String,
    @JSONField(name = "starred_gists_url")
    val starredGistsUrl: String,
    @JSONField(name = "team_url")
    val teamUrl: String,
    @JSONField(name = "user_url")
    val userUrl: String,
    @JSONField(name = "user_organizations_url")
    val userOrganizationsUrl: String,
    @JSONField(name = "user_repositories_url")
    val userRepositoriesUrl: String,
    @JSONField(name = "user_search_url")
    val userSearchUrl: String
)