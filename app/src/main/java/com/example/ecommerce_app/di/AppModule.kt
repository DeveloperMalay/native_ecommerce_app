package com.example.ecommerce_app.di

//import com.example.ecommerce_app.data.Api
//import com.example.ecommerce_app.data.ProductRepositoryImpl
//import dagger.Module
//import dagger.Provides
//import dagger.hilt.InstallIn
//import dagger.hilt.components.SingletonComponent
//import retrofit2.Retrofit
//import javax.inject.Singleton
//
//@Module
//@InstallIn(SingletonComponent::class)
//object AppModule {
//    @Provides
//    @Singleton
//    fun provideMyApi(): Api {
//        return Retrofit.Builder().baseUrl(Api.BASE_URL).build().create(Api::class.java)
//    }
//
//    @Provides
//    @Singleton
//    fun provideRepository(api: Api): ProductRepositoryImpl {
//        return ProductRepositoryImpl(api = api)
//    }
//
//
//}