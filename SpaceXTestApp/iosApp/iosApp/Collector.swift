//
//  Collector.swift
//  iosApp
//
//  Created by Aleksandr Shevelev on 13.03.2022.
//  Copyright © 2022 orgName. All rights reserved.
//

import Foundation
import shared

class Collector<T>: Kotlinx_coroutines_coreFlowCollector {

    let callback:(T) -> Void

    init(callback: @escaping (T) -> Void) {
        self.callback = callback
    }


    func emit(value: Any?, completionHandler: @escaping (KotlinUnit?, Error?) -> Void) {
        callback(value as! T)
        completionHandler(KotlinUnit(), nil)
    }
}
