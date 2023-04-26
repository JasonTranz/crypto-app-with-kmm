//
//  MenuViewModel.swift
//  iosApp
//
//  Created by Huu Tran on 26/04/2023.
//  Copyright © 2023 orgName. All rights reserved.
//

import Foundation
import SharedModule

class MenuViewModel: SharedModule.MenuKMMViewModel {
    
    override func getProtectedState(context: NSObject) -> Bool {
        super.getProtectedState(context: context)
    }
    
    override func setProtectedState(context: NSObject, isProtected: Bool) {
        super.setProtectedState(context: context, isProtected: isProtected)
    }
}