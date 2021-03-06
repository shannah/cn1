#import "xmlvm.h"
#import "java_lang_Object.h"
#import "org_apache_http_client_HttpClient.h"

// For circular include:
@class org_apache_http_HttpHost;
@class org_xmlvm_iphone_NSData;
@class java_lang_StringBuilder;
@class org_xmlvm_iphone_NSMutableURLRequest;
@class org_apache_http_params_HttpParams;
@class org_apache_http_impl_client_DefaultHttpClient;
@class org_apache_http_auth_AuthScope;
@class android_internal_Assert;
@class org_xmlvm_iphone_NSHTTPURLResponseHolder;
@class org_apache_http_HttpResponse;
@class org_apache_http_HttpRequest;
@class org_apache_http_HttpRequestInterceptor;
@class org_apache_http_client_methods_HttpGet;
@class java_util_ArrayList;
@class org_apache_http_client_HttpClient;
@class org_apache_http_auth_Credentials;
@class java_lang_Object;
@class org_apache_http_conn_ClientConnectionManager;
@class java_lang_String;
@class org_xmlvm_iphone_NSErrorHolder;
@class org_apache_http_impl_client_CredentialsProviderImpl;
@class org_xmlvm_iphone_NSURL;
@class org_apache_http_auth_UsernamePasswordCredentials;
@class org_apache_http_protocol_HttpContext;
@class org_apache_http_client_methods_HttpUriRequest;
@class org_apache_http_conn_impl_ClientConnectionManagerImpl;
@class org_apache_http_impl_client_DefaultHttpClient_Base64;
@class org_apache_http_impl_HttpResponseImpl;
@class org_xmlvm_iphone_NSURLConnection;
@class org_apache_http_client_CredentialsProvider;

// Automatically generated by xmlvm2obj. Do not edit!


	
@interface org_apache_http_impl_client_DefaultHttpClient : java_lang_Object <org_apache_http_client_HttpClient>
{
@public org_apache_http_client_CredentialsProvider* credentialsProvider_org_apache_http_client_CredentialsProvider;
@public org_apache_http_conn_ClientConnectionManager* clientConnectionManager_org_apache_http_conn_ClientConnectionManager;
@public java_util_ArrayList* httpRequestInterceptors_java_util_ArrayList;

}
+ (void) initialize;
- (id) init;
- (void) __init_org_apache_http_impl_client_DefaultHttpClient__;
- (void) __init_org_apache_http_impl_client_DefaultHttpClient___org_apache_http_conn_ClientConnectionManager_org_apache_http_params_HttpParams :(org_apache_http_conn_ClientConnectionManager*)n1 :(org_apache_http_params_HttpParams*)n2;
- (org_apache_http_params_HttpParams*) getParams__;
- (org_apache_http_HttpResponse*) execute___org_apache_http_client_methods_HttpUriRequest :(org_apache_http_client_methods_HttpUriRequest*)n1;
- (org_apache_http_HttpResponse*) execute___org_apache_http_HttpHost_org_apache_http_HttpRequest_org_apache_http_protocol_HttpContext :(org_apache_http_HttpHost*)n1 :(org_apache_http_HttpRequest*)n2 :(org_apache_http_protocol_HttpContext*)n3;
- (org_apache_http_conn_ClientConnectionManager*) getConnectionManager__;
- (org_apache_http_client_CredentialsProvider*) getCredentialsProvider__;
- (void) addRequestInterceptor___org_apache_http_HttpRequestInterceptor_int :(org_apache_http_HttpRequestInterceptor*)n1 :(int)n2;

@end

