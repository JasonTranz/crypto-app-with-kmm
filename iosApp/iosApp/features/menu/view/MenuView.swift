//
//  MenuView.swift
//  iosApp
//
//  Created by Huu Tran on 26/04/2023.
//  Copyright © 2023 orgName. All rights reserved.
//

import SwiftUI
import Foundation
import SharedModule
import KMMViewModelSwiftUI

struct MenuView: View {
    @StateViewModel var viewModel: MenuKMMViewModel = MenuViewModel()
    @State private var showGreeting = false
    var nsObject: NSObject = NSObject()
    
    var body: some View {
        VStack {
            HStack(alignment: .top) {
                Toggle("Protected device", isOn: $showGreeting)
                    .toggleStyle(SwitchToggleStyle(tint: .red))
                    .onChange(of: showGreeting) { value in
                        viewModel.setProtectedState(context: nsObject, isProtected: value)
                    }
                    .onAppear {
                        showGreeting = viewModel.getProtectedState(context: nsObject)
                    }
                    .padding(.trailing, 16).padding(.leading, 16)
            }.frame(maxWidth: .infinity, maxHeight: 40)
            Spacer()
        }.frame(maxWidth: .infinity, maxHeight: .infinity)
    }
}