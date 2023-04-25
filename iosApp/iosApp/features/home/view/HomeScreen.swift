//
//  HomeScreen.swift
//  iosApp
//
//  Created by Huu Tran on 25/04/2023.
//  Copyright © 2023 orgName. All rights reserved.
//
import SwiftUI
import Foundation

struct HomeScreen: View {

    var body: some View {
        GeometryReader { geometry in
            TabView {
                CoinListView()
                    .tabItem {
                        Image(systemName: "house")
                        Text("Home")
                    }
                
                PortfolioView()
                    .tabItem {
                        Image(systemName: "tray.2")
                        Text("Porfolio")
                    }
                
                SearchView()
                    .tabItem {
                        Image(systemName: "magnifyingglass")
                        Text("Search")
                    }
                
                ExploreView()
                    .tabItem {
                        Image(systemName: "paperplane")
                        Text("Explore")
                    }
                
                MenuView()
                    .tabItem {
                        Image(systemName: "list.bullet")
                        Text("Menu")
                    }
            }
        }
    }
}

struct PortfolioView: View {
    var body: some View {
        Text("Portfolio")
    }
}

struct SearchView: View {
    var body: some View {
        Text("Search")
    }
}

struct ExploreView: View {
    var body: some View {
        Text("Explore")
    }
}

struct MenuView: View {
    var body: some View {
        Text("Menu")
    }
}
